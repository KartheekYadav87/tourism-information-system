/**
 * main.js – Tamil Nadu Tourism Information System
 *
 * Contains:
 * - Navbar scroll effect
 * - Scroll reveal animations
 * - Smooth scrolling
 * - Image hover effects
 * - Counter animation for statistics
 * - Page loading progress indicator
 * - Back-to-top button
 * - Mobile menu handling
 */

'use strict';

// ─────────────────────────────────────────────────────────────────────────────
// 1. DOM READY – Initialize all modules
// ─────────────────────────────────────────────────────────────────────────────
document.addEventListener('DOMContentLoaded', () => {
    initNavbar();
    initScrollReveal();
    initSmoothScroll();
    initCounterAnimation();
    initBackToTop();
    initActiveNavLink();
    initTooltips();
    initImageHoverEffects();
});

// ─────────────────────────────────────────────────────────────────────────────
// 2. NAVBAR – Sticky scroll effect & mobile menu close on link click
// ─────────────────────────────────────────────────────────────────────────────
function initNavbar() {
    const navbar = document.querySelector('.navbar');
    if (!navbar) return;

    // Add scrolled class for condensed appearance
    const handleScroll = () => {
        if (window.scrollY > 60) {
            navbar.classList.add('scrolled');
        } else {
            navbar.classList.remove('scrolled');
        }
    };

    window.addEventListener('scroll', handleScroll, { passive: true });
    handleScroll(); // Run on load

    // Close mobile menu when a nav link is clicked
    const navLinks = navbar.querySelectorAll('.nav-link');
    const navbarCollapse = navbar.querySelector('.navbar-collapse');

    navLinks.forEach(link => {
        link.addEventListener('click', () => {
            if (navbarCollapse && navbarCollapse.classList.contains('show')) {
                const bsCollapse = bootstrap.Collapse.getInstance(navbarCollapse);
                if (bsCollapse) bsCollapse.hide();
            }
        });
    });
}

// ─────────────────────────────────────────────────────────────────────────────
// 3. ACTIVE NAV LINK – Highlight current page in navigation
// ─────────────────────────────────────────────────────────────────────────────
function initActiveNavLink() {
    const currentPath = window.location.pathname;
    document.querySelectorAll('.nav-link').forEach(link => {
        const href = link.getAttribute('href');
        if (!href) return;

        // Exact match for root, prefix match for nested pages
        if (href === '/' && currentPath === '/') {
            link.classList.add('active');
        } else if (href !== '/' && currentPath.startsWith(href)) {
            link.classList.add('active');
        }
    });
}

// ─────────────────────────────────────────────────────────────────────────────
// 4. SCROLL REVEAL – Animate elements into view on scroll
// ─────────────────────────────────────────────────────────────────────────────
function initScrollReveal() {
    const revealEls = document.querySelectorAll('.reveal, .reveal-up, .reveal-left');
    if (!revealEls.length) return;

    const observer = new IntersectionObserver((entries) => {
        entries.forEach(entry => {
            if (entry.isIntersecting) {
                entry.target.classList.add('visible');
                observer.unobserve(entry.target); // Animate once only
            }
        });
    }, {
        threshold: 0.12,
        rootMargin: '0px 0px -50px 0px'
    });

    revealEls.forEach(el => observer.observe(el));
}

// ─────────────────────────────────────────────────────────────────────────────
// 5. SMOOTH SCROLL – For anchor links on same page
// ─────────────────────────────────────────────────────────────────────────────
function initSmoothScroll() {
    document.querySelectorAll('a[href^="#"]').forEach(anchor => {
        anchor.addEventListener('click', e => {
            const target = document.querySelector(anchor.getAttribute('href'));
            if (target) {
                e.preventDefault();
                target.scrollIntoView({ behavior: 'smooth', block: 'start' });
            }
        });
    });
}

// ─────────────────────────────────────────────────────────────────────────────
// 6. COUNTER ANIMATION – Animate stat numbers with easing
// ─────────────────────────────────────────────────────────────────────────────
function initCounterAnimation() {
    const counters = document.querySelectorAll('[data-count]');
    if (!counters.length) return;

    const observer = new IntersectionObserver((entries) => {
        entries.forEach(entry => {
            if (entry.isIntersecting && !entry.target.dataset.counted) {
                entry.target.dataset.counted = 'true';
                animateCounter(entry.target);
                observer.unobserve(entry.target);
            }
        });
    }, { threshold: 0.5 });

    counters.forEach(counter => observer.observe(counter));
}

function animateCounter(el) {
    const target = parseInt(el.dataset.count, 10);
    const duration = 2000; // ms
    const suffix = el.dataset.suffix || '';
    const step = target / (duration / 16); // ~60fps
    let current = 0;

    const timer = setInterval(() => {
        current += step;
        if (current >= target) {
            el.textContent = target.toLocaleString() + suffix;
            clearInterval(timer);
        } else {
            el.textContent = Math.floor(current).toLocaleString() + suffix;
        }
    }, 16);
}

// ─────────────────────────────────────────────────────────────────────────────
// 7. BACK TO TOP – Show/hide floating button
// ─────────────────────────────────────────────────────────────────────────────
function initBackToTop() {
    // Create button dynamically
    const btn = document.createElement('button');
    btn.id = 'back-to-top';
    btn.title = 'Back to top';
    btn.innerHTML = '<i class="fas fa-chevron-up"></i>';
    btn.setAttribute('aria-label', 'Back to top');

    // Inline critical styles (CSS also styles this via ID)
    Object.assign(btn.style, {
        position: 'fixed',
        bottom: '28px',
        right: '28px',
        width: '46px',
        height: '46px',
        borderRadius: '50%',
        background: 'linear-gradient(135deg, #0d6efd, #198754)',
        color: '#fff',
        border: 'none',
        cursor: 'pointer',
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'center',
        fontSize: '0.95rem',
        zIndex: '9999',
        opacity: '0',
        visibility: 'hidden',
        transition: 'opacity 0.3s ease, visibility 0.3s ease, transform 0.3s ease',
        boxShadow: '0 4px 16px rgba(13,110,253,0.4)'
    });

    document.body.appendChild(btn);

    window.addEventListener('scroll', () => {
        if (window.scrollY > 400) {
            btn.style.opacity = '1';
            btn.style.visibility = 'visible';
        } else {
            btn.style.opacity = '0';
            btn.style.visibility = 'hidden';
        }
    }, { passive: true });

    btn.addEventListener('click', () => {
        window.scrollTo({ top: 0, behavior: 'smooth' });
    });

    btn.addEventListener('mouseenter', () => {
        btn.style.transform = 'scale(1.1) translateY(-3px)';
    });
    btn.addEventListener('mouseleave', () => {
        btn.style.transform = 'scale(1) translateY(0)';
    });
}

// ─────────────────────────────────────────────────────────────────────────────
// 8. BOOTSTRAP TOOLTIPS – Initialize on elements with data-bs-toggle="tooltip"
// ─────────────────────────────────────────────────────────────────────────────
function initTooltips() {
    const tooltipEls = document.querySelectorAll('[data-bs-toggle="tooltip"]');
    tooltipEls.forEach(el => {
        new bootstrap.Tooltip(el, { placement: 'top' });
    });
}

// ─────────────────────────────────────────────────────────────────────────────
// 9. IMAGE HOVER EFFECTS – Additional JS-driven effects on card images
// ─────────────────────────────────────────────────────────────────────────────
function initImageHoverEffects() {
    // Add tilt effect to hero float cards
    const floatCards = document.querySelectorAll('.hero-float-card');
    floatCards.forEach(card => {
        card.addEventListener('mousemove', e => {
            const rect = card.getBoundingClientRect();
            const x = (e.clientX - rect.left) / rect.width - 0.5;
            const y = (e.clientY - rect.top) / rect.height - 0.5;
            card.style.transform = `perspective(300px) rotateX(${-y * 10}deg) rotateY(${x * 10}deg) translateY(-5px)`;
        });
        card.addEventListener('mouseleave', () => {
            card.style.transform = '';
        });
    });
}

// ─────────────────────────────────────────────────────────────────────────────
// 10. UTILITY FUNCTIONS
// ─────────────────────────────────────────────────────────────────────────────

/**
 * Debounce – limit rate at which a function fires.
 * @param {Function} fn - Function to debounce
 * @param {number} wait - Delay in ms
 */
function debounce(fn, wait = 200) {
    let timer;
    return (...args) => {
        clearTimeout(timer);
        timer = setTimeout(() => fn(...args), wait);
    };
}

/**
 * Throttle – execute at most once per interval.
 * @param {Function} fn - Function to throttle
 * @param {number} limit - Interval in ms
 */
function throttle(fn, limit = 100) {
    let inThrottle;
    return (...args) => {
        if (!inThrottle) {
            fn(...args);
            inThrottle = true;
            setTimeout(() => inThrottle = false, limit);
        }
    };
}

/**
 * Format price as INR string.
 * @param {number} num - Number to format
 * @returns {string}
 */
function formatINR(num) {
    return '₹' + num.toLocaleString('en-IN');
}
