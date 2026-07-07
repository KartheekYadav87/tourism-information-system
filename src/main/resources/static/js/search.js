/**
 * search.js – Tamil Nadu Tourism Information System
 *
 * Implements live search for:
 * - Attractions page (by name, district, category)
 * - Hotels page (by name, location, category)
 * - Category filter chip click filtering
 * - Combined search + filter state management
 */

'use strict';

document.addEventListener('DOMContentLoaded', () => {
    // Initialize search modules based on current page
    if (document.getElementById('attraction-search')) {
        initAttractionSearch();
    }
    if (document.getElementById('hotel-search')) {
        initHotelSearch();
    }
});

// ─────────────────────────────────────────────────────────────────────────────
// 1. ATTRACTION SEARCH & FILTER
// ─────────────────────────────────────────────────────────────────────────────

function initAttractionSearch() {
    const searchInput  = document.getElementById('attraction-search');
    const filterBtns   = document.querySelectorAll('.cat-filter-btn');
    const cards        = document.querySelectorAll('.attraction-card-wrapper');
    const resultCount  = document.getElementById('result-count');
    const emptyState   = document.getElementById('empty-state');

    let currentFilter  = 'all';
    let currentQuery   = '';

    // ── Search Input Handler ──
    searchInput.addEventListener('input', debounce(e => {
        currentQuery = e.target.value.trim().toLowerCase();
        applyAttractionFilter();
    }, 220));

    // Clear search on Escape key
    searchInput.addEventListener('keydown', e => {
        if (e.key === 'Escape') {
            searchInput.value = '';
            currentQuery = '';
            applyAttractionFilter();
        }
    });

    // ── Category Filter Buttons ──
    filterBtns.forEach(btn => {
        btn.addEventListener('click', () => {
            filterBtns.forEach(b => b.classList.remove('active'));
            btn.classList.add('active');
            currentFilter = btn.dataset.filter || 'all';
            applyAttractionFilter();
        });
    });

    // ── Core Filtering Logic ──
    function applyAttractionFilter() {
        let visible = 0;

        cards.forEach(wrapper => {
            const card       = wrapper.querySelector('.attraction-card');
            const name       = (card.dataset.name       || '').toLowerCase();
            const district   = (card.dataset.district   || '').toLowerCase();
            const category   = (card.dataset.category   || '').toLowerCase();

            // Category filter match
            const catMatch     = currentFilter === 'all' || category === currentFilter.toLowerCase();
            // Text search match
            const searchMatch  = !currentQuery ||
                name.includes(currentQuery) ||
                district.includes(currentQuery) ||
                category.includes(currentQuery);

            const show = catMatch && searchMatch;

            // Apply animation classes
            if (show) {
                wrapper.style.display = '';
                wrapper.classList.remove('filtered-out');
                visible++;
            } else {
                wrapper.style.display = 'none';
                wrapper.classList.add('filtered-out');
            }
        });

        // Update result count display
        if (resultCount) {
            resultCount.querySelector('span').textContent = visible;
        }

        // Toggle empty state message
        if (emptyState) {
            emptyState.style.display = visible === 0 ? '' : 'none';
        }
    }
}

// ─────────────────────────────────────────────────────────────────────────────
// 2. HOTEL SEARCH & FILTER
// ─────────────────────────────────────────────────────────────────────────────

function initHotelSearch() {
    const searchInput  = document.getElementById('hotel-search');
    const starFilter   = document.getElementById('star-filter');
    const catFilter    = document.getElementById('cat-filter');
    const priceRange   = document.getElementById('price-range');
    const priceDisplay = document.getElementById('price-display');
    const cards        = document.querySelectorAll('.hotel-card-wrapper');
    const resultCount  = document.getElementById('hotel-result-count');
    const emptyState   = document.getElementById('hotel-empty-state');

    let currentQuery   = '';
    let currentStars   = 0;
    let currentCat     = 'all';
    let maxPrice       = Infinity;

    // ── Price Range ──
    if (priceRange) {
        priceRange.addEventListener('input', () => {
            maxPrice = parseInt(priceRange.value, 10);
            if (priceDisplay) {
                priceDisplay.textContent = '₹' + maxPrice.toLocaleString('en-IN');
            }
            applyHotelFilter();
        });
    }

    // ── Search Input ──
    if (searchInput) {
        searchInput.addEventListener('input', debounce(e => {
            currentQuery = e.target.value.trim().toLowerCase();
            applyHotelFilter();
        }, 220));

        searchInput.addEventListener('keydown', e => {
            if (e.key === 'Escape') {
                searchInput.value = '';
                currentQuery = '';
                applyHotelFilter();
            }
        });
    }

    // ── Star Filter ──
    if (starFilter) {
        starFilter.addEventListener('change', () => {
            currentStars = parseInt(starFilter.value, 10) || 0;
            applyHotelFilter();
        });
    }

    // ── Category Filter ──
    if (catFilter) {
        catFilter.addEventListener('change', () => {
            currentCat = catFilter.value || 'all';
            applyHotelFilter();
        });
    }

    // ── Category Chips on hotel page ──
    document.querySelectorAll('.hotel-cat-chip').forEach(chip => {
        chip.addEventListener('click', () => {
            document.querySelectorAll('.hotel-cat-chip').forEach(c => c.classList.remove('active'));
            chip.classList.add('active');
            currentCat = chip.dataset.cat || 'all';
            if (catFilter) catFilter.value = currentCat;
            applyHotelFilter();
        });
    });

    // ── Core Filtering Logic ──
    function applyHotelFilter() {
        let visible = 0;

        cards.forEach(wrapper => {
            const card     = wrapper.querySelector('.hotel-card');
            const name     = (card.dataset.name     || '').toLowerCase();
            const location = (card.dataset.location || '').toLowerCase();
            const stars    = parseInt(card.dataset.stars    || '0', 10);
            const category = (card.dataset.category || '').toLowerCase();
            const price    = parseFloat(card.dataset.price  || '0');

            const searchMatch = !currentQuery ||
                name.includes(currentQuery) ||
                location.includes(currentQuery);

            const starsMatch = currentStars === 0 || stars === currentStars;

            const catMatch = currentCat === 'all' ||
                category === currentCat.toLowerCase();

            const priceMatch = isNaN(maxPrice) || price <= maxPrice;

            const show = searchMatch && starsMatch && catMatch && priceMatch;

            wrapper.style.display = show ? '' : 'none';
            if (show) visible++;
        });

        // Update result count
        if (resultCount) {
            resultCount.textContent = visible + ' hotel' + (visible !== 1 ? 's' : '');
        }

        // Toggle empty state
        if (emptyState) {
            emptyState.style.display = visible === 0 ? '' : 'none';
        }
    }
}

// ─────────────────────────────────────────────────────────────────────────────
// 3. UTILITY FUNCTIONS
// ─────────────────────────────────────────────────────────────────────────────

/**
 * Debounce – limit how often a function fires.
 * @param {Function} fn
 * @param {number} wait
 */
function debounce(fn, wait = 200) {
    let timer;
    return (...args) => {
        clearTimeout(timer);
        timer = setTimeout(() => fn(...args), wait);
    };
}
