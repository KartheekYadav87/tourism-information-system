package com.tourism.service;

import com.tourism.model.Attraction;
import com.tourism.model.Guide;
import com.tourism.model.Hotel;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Service layer providing all tourism data.
 * Currently uses hardcoded data; can be replaced with a JPA repository in future.
 */
@Service
public class TourismService {

    // =========================================================================
    // ATTRACTIONS DATA
    // =========================================================================

    public List<Attraction> getAllAttractions() {
        return Arrays.asList(
            new Attraction(1L, "Marina Beach",
                "Chennai", "Beach",
                "Marina Beach is the longest natural urban beach in India, stretching over 13 km along the Bay of Bengal. " +
                "A beloved destination for morning walkers, families, and tourists, it offers stunning sunrise views, " +
                "street food stalls, statues of famous historical personalities, and a lively atmosphere throughout the day. " +
                "The beach is lined with ice cream vendors, sundal sellers, and horse riders making it a complete experience.",
                "beach.jpg", "Open 24 hours", "Free", "October – February",
                13.0500, 80.2824),

            new Attraction(2L, "Brihadeeswarar Temple",
                "Thanjavur", "Temple",
                "A UNESCO World Heritage Site and a masterpiece of Dravidian architecture, Brihadeeswarar Temple " +
                "was built by Raja Raja Chola I in 1010 AD. The towering 66-metre vimana is made entirely from granite " +
                "and casts virtually no shadow at noon. The temple complex contains magnificent sculptures, frescoes, " +
                "and inscriptions that narrate the glorious Chola dynasty. Visiting this temple is a spiritual and " +
                "historical journey into ancient Tamil civilization.",
                "temple.jpg", "6:00 AM – 12:30 PM, 4:00 PM – 8:30 PM", "Free", "October – March",
                10.7828, 79.1318),

            new Attraction(3L, "Hogenakkal Falls",
                "Dharmapuri", "Waterfall",
                "Known as the 'Niagara of India', Hogenakkal Falls is a breathtaking waterfall on the Kaveri River. " +
                "Visitors can enjoy thrilling coracle boat rides through the mist-draped gorges of ancient carbonatite rocks, " +
                "some of the oldest in the world. The falls are surrounded by thick forests and the region is famous for " +
                "its oil bath massage treatment offered by traditional barbers on the riverbanks. A truly unforgettable experience.",
                "waterfall.jpg", "6:00 AM – 6:00 PM", "Rs. 50 per person", "July – October",
                12.1268, 77.7901),

            new Attraction(4L, "Mahabalipuram Shore Temple",
                "Kancheepuram", "Temple",
                "The Shore Temple at Mahabalipuram is a UNESCO World Heritage Site standing majestically on the shores " +
                "of the Bay of Bengal. Built during the reign of Pallava king Narasimhavarman II in the 8th century, " +
                "it represents one of the finest examples of Pallava architecture. The complex includes intricate carvings, " +
                "monolithic rock-cut sculptures, and the famous Pancha Rathas. Watching sunset at Shore Temple is " +
                "an experience that stays with you forever.",
                "temple.jpg", "6:00 AM – 6:00 PM", "Rs. 40 Indians, Rs. 600 Foreigners", "November – March",
                12.6161, 80.1996),

            new Attraction(5L, "Ooty – Queen of Hill Stations",
                "Nilgiris", "Hill Station",
                "Udhagamandalam, popularly known as Ooty, is the most celebrated hill station in South India, " +
                "perched at 2,240 metres above sea level in the Nilgiri Hills. Famous for its sprawling tea estates, " +
                "Botanical Gardens with over 1,000 species of plants, Ooty Lake, and the UNESCO-listed Nilgiri Mountain Railway, " +
                "Ooty offers a refreshing escape from the plains. Strawberry and eucalyptus farms add to the charm of this " +
                "enchanting destination throughout the year.",
                "hero.jpg", "Always open (specific attractions vary)", "Rs. 30 – Rs. 50 per site", "April – June, September – November",
                11.4102, 76.6950),

            new Attraction(6L, "Mudumalai Wildlife Sanctuary",
                "Nilgiris", "Wildlife",
                "Mudumalai National Park is one of India's premier tiger reserves, situated at the foothills of the " +
                "Nilgiri Hills. Spanning over 320 sq km, it is home to tigers, leopards, Asian elephants, bison, deer, " +
                "and over 250 bird species. The sanctuary is part of the Nilgiris Biosphere Reserve — a UNESCO World Heritage Site. " +
                "Jeep safaris and elephant rides through dense teak and rosewood forests offer thrilling wildlife encounters " +
                "and unforgettable nature experiences.",
                "hero.jpg", "6:00 AM – 9:00 AM, 3:00 PM – 6:00 PM", "Rs. 25 per person (Safari extra)", "October – June",
                11.5500, 76.5300),

            new Attraction(7L, "Kodaikanal Lake",
                "Dindigul", "Hill Station",
                "Kodaikanal, known as the 'Princess of Hill Stations', is home to the iconic star-shaped Kodaikanal Lake. " +
                "Surrounded by eucalyptus groves and shola forests at 2,133 metres elevation, it offers boating, cycling, " +
                "horse riding, and trekking to Bryant Park, Pillar Rocks, and Silver Cascade Falls. " +
                "The Kurinji flower blooms once in 12 years on the Palani Hills, making it a rare and special spectacle. " +
                "Kodaikanal's tranquil ambience makes it perfect for honeymooners and nature lovers.",
                "waterfall.jpg", "Always open", "Free to enter town", "April – June",
                10.2381, 77.4892),

            new Attraction(8L, "Rameswaram Temple",
                "Ramanathapuram", "Temple",
                "Rameswaram is one of the holiest pilgrimage sites in Hinduism, located on Pamban Island. " +
                "The Ramanathaswamy Temple is famous for its magnificent corridors — the longest in any Hindu temple at 1,220 metres. " +
                "With 22 sacred theerthams (holy wells) where pilgrims bathe, and its location near the legendary Adam's Bridge, " +
                "Rameswaram holds immense spiritual significance. The island is also associated with the epic Ramayana " +
                "and offers stunning views of the Palk Strait.",
                "temple.jpg", "5:00 AM – 1:00 PM, 3:00 PM – 9:00 PM", "Free", "October – April",
                9.2876, 79.3129),

            new Attraction(9L, "Kanyakumari – Land's End",
                "Kanyakumari", "Beach",
                "Kanyakumari, the southernmost tip of India, is where the Arabian Sea, Bay of Bengal, and Indian Ocean converge. " +
                "Famous for sunrise and sunset views from the same spot, it is home to the Vivekananda Rock Memorial, " +
                "Thiruvalluvar Statue, the ancient Kumari Amman Temple, and the magnificent Wax Museum. " +
                "The confluence of three seas creates a spectacular tricolor effect in the water. " +
                "Kanyakumari combines spiritual significance with breathtaking natural beauty.",
                "beach.jpg", "Always open", "Rs. 70 for Vivekananda Rock (boat extra)", "October – March",
                8.0883, 77.5385),

            new Attraction(10L, "Yelagiri Hills",
                "Vellore", "Hill Station",
                "Yelagiri is a peaceful hill station at 1,100 metres altitude, often called the 'poor man's Ooty' " +
                "for its accessibility and tranquility. The plateau is home to Swamimalai Hill trekking trails, " +
                "Punganur Lake with paddle boating, paragliding adventures, and an orchidarium with rare species. " +
                "Nature trails through pine and fruit orchards are a delight for trekkers. " +
                "The cool climate and less commercialized atmosphere make it ideal for a weekend retreat.",
                "waterfall.jpg", "Always open", "Free", "October – April",
                12.5734, 78.6461),

            new Attraction(11L, "Thanjavur Art Gallery & Palace",
                "Thanjavur", "Museum",
                "The Thanjavur Royal Palace and Art Gallery is a treasure trove of Chola bronzes, stone sculptures, " +
                "and Tanjore paintings from the 10th to 12th centuries. The palace complex includes the Royal Museum, " +
                "the Saraswathi Mahal Library housing over 44,000 manuscripts in multiple languages, " +
                "and the Bell Tower offering panoramic views of the city. " +
                "This museum is a must-visit for history enthusiasts and art lovers wishing to explore " +
                "the spectacular cultural heritage of the Chola Empire.",
                "hero.jpg", "9:00 AM – 1:00 PM, 3:00 PM – 6:00 PM (Closed Fri)", "Rs. 10 Indians, Rs. 250 Foreigners", "October – March",
                10.7860, 79.1378),

            new Attraction(12L, "Gulf of Mannar Marine National Park",
                "Ramanathapuram", "Wildlife",
                "The Gulf of Mannar Marine National Park is India's first marine national park, encompassing " +
                "21 islands spread across 160 sq km of coral reef ecosystems. It hosts diverse marine biodiversity " +
                "including sea turtles, dugongs, dolphins, sea horses, and over 3,600 marine species. " +
                "Glass-bottomed boat rides reveal spectacular coral gardens without getting wet. " +
                "The park is a paradise for snorkelers and marine biologists studying Indo-Pacific reef systems.",
                "beach.jpg", "6:00 AM – 5:00 PM", "Rs. 200 per person + boat charges", "November – April",
                9.1260, 79.2046),

            new Attraction(13L, "Anamalai Tiger Reserve",
                "Coimbatore", "Wildlife",
                "Previously known as Indira Gandhi Wildlife Sanctuary, Anamalai Tiger Reserve spans 1,479 sq km " +
                "of the Western Ghats, hosting tigers, leopards, wild dogs, giant squirrels, and a remarkable variety " +
                "of birds including hornbills and flycatchers. The reserve is also famous for its elephant population " +
                "and the Topslip region offers jeep safaris and nature walks. " +
                "The diverse flora transitions from dry deciduous to moist evergreen forests, drawing botanists and naturalists.",
                "hero.jpg", "6:00 AM – 6:00 PM", "Rs. 15 per person (Safari: Rs. 50–Rs. 200)", "October – June",
                10.4244, 77.0468),

            new Attraction(14L, "Courtallam Falls",
                "Tenkasi", "Waterfall",
                "Known as the 'Spa of South India', Courtallam (Kutralam) is a group of spectacular waterfalls " +
                "in the Tirunelveli district, famous for their medicinal properties attributed to herbs on the hillside. " +
                "The main falls, five falls, and old falls each offer unique bathing experiences. " +
                "During the monsoon season (June–September), the falls are at their most powerful and therapeutic. " +
                "Ayurvedic oil bath services on the riverbanks add to the wellness experience.",
                "waterfall.jpg", "6:00 AM – 6:00 PM", "Free", "June – September (peak), Nov–Feb (pleasant)",
                8.9307, 77.2752),

            new Attraction(15L, "Vellore Fort & Golden Temple",
                "Vellore", "Heritage",
                "Vellore Fort is a 16th-century military citadel built by the Vijayanagara Empire, surrounded by a " +
                "deep moat, massive granite walls, and a history steeped in colonial battles. The fort houses a church, " +
                "a mosque, and government offices within its premises. " +
                "Nearby, the Sripuram Golden Temple (Narayani Amba Temple) is a modern marvel covered in 1,500 kg of pure gold, " +
                "radiating magnificence especially when illuminated at night. Together, these sites offer " +
                "a perfect blend of historical and spiritual exploration.",
                "temple.jpg", "6:00 AM – 8:00 PM", "Fort: Free; Temple: Rs. 50–Rs. 500", "October – March",
                12.9165, 79.1325)
        );
    }

    /**
     * Find a single attraction by its ID.
     */
    public Optional<Attraction> getAttractionById(Long id) {
        return getAllAttractions().stream()
                .filter(a -> a.getId().equals(id))
                .findFirst();
    }

    // =========================================================================
    // HOTELS DATA
    // =========================================================================

    public List<Hotel> getAllHotels() {
        return Arrays.asList(
            new Hotel(1L, "The Leela Palace Chennai",
                "Anna Salai, Chennai", 5, 18500.0,
                Arrays.asList("Swimming Pool", "Spa", "Fine Dining", "Gym", "Concierge", "Business Center", "Valet Parking", "Airport Shuttle"),
                "https://www.theleela.com", "hotel.jpg", "Luxury",
                "A palatial 5-star luxury hotel set amidst lush gardens in the heart of Chennai. " +
                "Blending classical architecture with contemporary elegance, The Leela Palace offers " +
                "world-class dining, a rejuvenating spa, and impeccable service that define the pinnacle of Indian hospitality.",
                "+91-44-3366-1234", "reservations.chennai@theleela.com"),

            new Hotel(2L, "Vivanta Fisherman's Cove",
                "ECR, Chennai", 5, 15800.0,
                Arrays.asList("Private Beach", "Swimming Pool", "Water Sports", "Spa", "Multiple Restaurants", "Gym", "Kids Club"),
                "https://www.vivantahotels.com", "hotel.jpg", "Resort",
                "Set on a pristine private beach on the East Coast Road, Vivanta Fisherman's Cove offers " +
                "charming cottages and rooms with breathtaking sea views. An ideal retreat combining " +
                "luxury resort amenities with the serenity of the Bay of Bengal. Perfect for beach lovers.",
                "+91-44-6741-3333", "info.fishermanscove@vivanta.com"),

            new Hotel(3L, "Taj Coromandel",
                "Nungambakkam, Chennai", 5, 16200.0,
                Arrays.asList("Rooftop Pool", "Award-winning Dining", "Spa", "Gym", "Butler Service", "Limousine"),
                "https://www.tajhotels.com", "hotel.jpg", "Luxury",
                "A landmark of luxury in Chennai's business district, Taj Coromandel has been synonymous " +
                "with excellence since 1974. Featuring award-winning restaurants, a rooftop pool with city views, " +
                "and legendary Taj hospitality, it remains the preferred address for discerning travelers and dignitaries.",
                "+91-44-6600-2827", "coromandel.chennai@tajhotels.com"),

            new Hotel(4L, "Savoy Hotel Ooty",
                "Ooty, Nilgiris", 4, 8500.0,
                Arrays.asList("Heritage Building", "Landscaped Gardens", "Fireplace", "Restaurant", "Room Service", "Parking"),
                "https://www.savoytheooty.com", "hotel.jpg", "Heritage",
                "Established in 1829, the Savoy Hotel is Ooty's finest heritage property that has hosted " +
                "royalty, governors, and celebrated guests over two centuries. Stone cottages with fireplaces, " +
                "manicured English gardens, and the scent of eucalyptus create a timeless colonial experience " +
                "amidst the Nilgiri Hills.",
                "+91-423-224-2212", "reservations@savoytheooty.com"),

            new Hotel(5L, "Kodai Resort Hotel",
                "Anna Salai, Kodaikanal", 4, 6200.0,
                Arrays.asList("Mountain View", "Restaurant", "Bonfire Deck", "Trekking Guide", "Room Service", "Parking"),
                "https://www.kodairesort.com", "hotel.jpg", "Resort",
                "Perched at 2,100 metres with panoramic views of the Palani Hills, Kodai Resort Hotel " +
                "offers cozy rooms with private balconies overlooking misty valleys. " +
                "A warm bonfire deck, homely restaurant serving local cuisine, and guided trekking packages " +
                "make this the ideal base for exploring Kodaikanal's pristine wilderness.",
                "+91-4542-241-241", "bookings@kodairesort.com"),

            new Hotel(6L, "GRT Temple Bay",
                "Mahabalipuram", 5, 12800.0,
                Arrays.asList("Private Beach", "Ayurvedic Spa", "Pool", "Scuba Diving", "Restaurants", "Cultural Programs"),
                "https://www.grthotels.com", "hotel.jpg", "Resort",
                "GRT Temple Bay in Mahabalipuram is a stunning beachfront resort spread across 27 acres " +
                "of landscaped tropical gardens. With its own private beach, world-class scuba diving center, " +
                "and an Ayurvedic spa, this resort is the perfect destination for sea adventures and relaxation " +
                "within walking distance of the UNESCO World Heritage sculptures.",
                "+91-44-2744-3636", "templebay@grthotels.com"),

            new Hotel(7L, "Hotel Pearl Residency",
                "Trichy", 3, 2800.0,
                Arrays.asList("AC Rooms", "Restaurant", "Wi-Fi", "Parking", "Travel Desk", "Room Service"),
                "https://www.hotelpearlresidency.com", "hotel.jpg", "Budget",
                "A comfortable and affordable hotel in the heart of Trichy, Hotel Pearl Residency offers " +
                "clean, well-maintained rooms at great value. Ideally located near Srirangam Temple, " +
                "the hotel provides easy access to all major attractions. A reliable choice for budget travelers " +
                "who don't want to compromise on hygiene or service.",
                "+91-431-241-5050", "info@hotelpearlresidency.com"),

            new Hotel(8L, "Jungle Retreat Mudumalai",
                "Bokkapuram, Nilgiris", 3, 4500.0,
                Arrays.asList("Nature Walks", "Bird Watching", "Campfire", "Organic Farm", "Eco-Cottages", "Jeep Safari"),
                "https://www.jungleretreat.in", "hotel.jpg", "Resort",
                "Nestled on the boundary of Mudumalai Tiger Reserve, Jungle Retreat is an award-winning " +
                "eco-resort offering authentic wildlife experiences. Stilted bamboo cottages, jungle walks led by " +
                "expert naturalists, and night safari drives create an unforgettable wildlife immersion. " +
                "Completely solar-powered with organic farm-to-table meals, it is a model for sustainable tourism.",
                "+91-423-252-6469", "stay@jungleretreat.in"),

            new Hotel(9L, "Sterling Yercaud",
                "Yercaud, Salem", 4, 5500.0,
                Arrays.asList("Mountain View", "Swimming Pool", "Restaurant", "Indoor Games", "Trekking", "Cycling"),
                "https://www.sterlingholidays.com", "hotel.jpg", "Resort",
                "Sterling Yercaud is a delightful resort amid coffee and pepper plantations on the Shevaroy Hills. " +
                "Comfortable cottages with eucalyptus-scented air, a swimming pool with valley views, " +
                "and guided plantation walks make this a wonderful escape for families and couples. " +
                "The resort also organizes adventure activities including rappelling and cycling tours.",
                "+91-427-222-3232", "yercaud@sterlingholidays.com"),

            new Hotel(10L, "Dune Eco Village",
                "Puducherry", 4, 7200.0,
                Arrays.asList("Lagoon View", "Organic Restaurant", "Yoga Studio", "Cycling", "Kayaking", "Cooking Classes"),
                "https://www.dunepuducherry.com", "hotel.jpg", "Resort",
                "The Dune Eco Village in Puducherry is a serene haven on the Chunnambar Backwaters. " +
                "Traditional tile-roofed villas set around a lagoon, a farm-to-table organic restaurant, " +
                "yoga sessions at dawn, and kayaking through mangroves create a mindful travel experience. " +
                "A perfect blend of wellness, culture, and natural beauty.",
                "+91-413-265-5751", "reservations@dunepuducherry.com"),

            new Hotel(11L, "Hotel Tamil Nadu – Kanyakumari",
                "Kanyakumari", 3, 3200.0,
                Arrays.asList("Sea View Rooms", "Restaurant", "Parking", "Wi-Fi", "Travel Assistance"),
                "https://www.tamilnadutourism.tn.gov.in", "hotel.jpg", "Budget",
                "Run by the Tamil Nadu Tourism Development Corporation (TTDC), Hotel Tamil Nadu in Kanyakumari " +
                "offers budget-friendly rooms with spectacular views of the three-sea junction. " +
                "Located steps away from the ferry point to Vivekananda Rock Memorial, it provides excellent " +
                "value accommodation at one of India's most visited pilgrimage and tourist destinations.",
                "+91-4652-246-257", "htlkanyakumari@ttdc.in"),

            new Hotel(12L, "The Park Chennai",
                "Nungambakkam, Chennai", 4, 9800.0,
                Arrays.asList("Rooftop Bar", "Infinity Pool", "Nightclub", "Spa", "Multiple Restaurants", "Gym"),
                "https://www.theparkhotels.com", "hotel.jpg", "Luxury",
                "An iconic design hotel in the cultural heart of Chennai, The Park is known for its bold art " +
                "installations, trendy rooftop bar Pasha, and infinity pool overlooking Nungambakkam. " +
                "Blending contemporary design with Tamil culture, it attracts creative professionals, " +
                "business travelers, and lifestyle seekers looking for a chic urban hospitality experience.",
                "+91-44-4267-6000", "reservations.chennai@theparkhotels.com"),

            new Hotel(13L, "Residency Towers Trichy",
                "MacDonald's Road, Trichy", 4, 4800.0,
                Arrays.asList("Swimming Pool", "Gym", "Rooftop Restaurant", "Business Center", "Banquet Hall"),
                "https://www.theresidency.com", "hotel.jpg", "Business",
                "Residency Towers is the premier business hotel in Trichy, offering polished rooms, " +
                "a rooftop restaurant with panoramic views of the city, and extensive conference facilities. " +
                "Conveniently located near Srirangam and Rock Fort Temple, it is the top choice for " +
                "business travelers visiting this temple city.",
                "+91-431-414-1414", "reservations.trichy@theresidency.com"),

            new Hotel(14L, "YMCA International Guest House",
                "Nandanam, Chennai", 2, 1200.0,
                Arrays.asList("AC Dormitory", "Canteen", "Common Area", "Wi-Fi", "Locker Facility"),
                "https://www.ymcachennai.org", "hotel.jpg", "Budget",
                "One of Chennai's most affordable and trusted budget accommodations, YMCA International " +
                "Guest House offers clean dormitory and private rooms in a safe, friendly environment. " +
                "Popular among backpackers, students, and solo travellers, it provides basic amenities " +
                "at extremely reasonable rates with central city location.",
                "+91-44-2432-2040", "igc@ymcachennai.org"),

            new Hotel(15L, "Le Méridien Coimbatore",
                "Avinashi Road, Coimbatore", 5, 11500.0,
                Arrays.asList("Rooftop Pool", "Spa", "Multiple Restaurants", "Gym", "Business Center", "Airport Shuttle"),
                "https://www.marriott.com", "hotel.jpg", "Luxury",
                "Le Méridien Coimbatore brings international luxury to the gateway of the Nilgiris. " +
                "With its stunning architecture, rooftop infinity pool, world-class dining including " +
                "the award-winning Kangan restaurant, and a state-of-the-art spa, it is the finest " +
                "5-star address in Coimbatore for both business and leisure travelers.",
                "+91-422-666-6666", "reservations.coimbatore@lemeridien.com")
        );
    }

    /**
     * Find a single hotel by its ID.
     */
    public Optional<Hotel> getHotelById(Long id) {
        return getAllHotels().stream()
                .filter(h -> h.getId().equals(id))
                .findFirst();
    }

    // =========================================================================
    // GUIDES DATA
    // =========================================================================

    public List<Guide> getAllGuides() {
        return Arrays.asList(
            new Guide(1L, "Getting Around Tamil Nadu",
                "Tamil Nadu has an excellent multi-modal transportation network. " +
                "The state capital Chennai is served by two major railway terminals — Chennai Central and Chennai Egmore — " +
                "connecting all major cities within the state and across India. " +
                "The MTC bus network in Chennai is extensive, and the CMRL Metro serves key urban corridors. " +
                "For inter-city travel, Tamil Nadu State Transport Corporation (TNSTC) operates affordable express bus services " +
                "connecting all district headquarters. Auto-rickshaws and app-based cabs (Ola, Uber) " +
                "are readily available in most cities. Hiring a self-drive car or a chauffeur-driven vehicle " +
                "remains the most convenient option for visiting remote temples, hill stations, and waterfalls. " +
                "The state has over 7 airports including Chennai, Coimbatore, Trichy, and Madurai offering regional connectivity.",
                "fas fa-bus", "Transportation"),

            new Guide(2L, "Local Food & Cuisine",
                "Tamil Nadu's cuisine is a gastronomic paradise centered around rice, lentils, and aromatic spices. " +
                "The iconic South Indian breakfast features idli-sambar, crispy dosas, uthappam, and vadas " +
                "served on banana leaves in traditional hotels. Chettinad cuisine from the Sivaganga district " +
                "is world-famous for its bold use of kalpasi, maratti mokku, and star anise in non-vegetarian dishes. " +
                "A traditional Tamil lunch — a full meals — is an elaborate affair with rice, six types of gravies, " +
                "papad, pickles, and payasam dessert, all served on a banana leaf. " +
                "Street food highlights include kothu parotta, egg dosa, murukku, and filter coffee poured from a " +
                "steel tumbler into a dabarah. The coastal regions offer fresh seafood — especially crab, prawn, and fish curries. " +
                "Always carry a good appetite when visiting Tamil Nadu!",
                "fas fa-utensils", "Food"),

            new Guide(3L, "Safety Tips for Travelers",
                "Tamil Nadu is generally a safe and welcoming state for tourists. " +
                "Always keep photocopies or digital copies of your passport, visa, and important documents. " +
                "Use only pre-paid taxi/auto services from official airport and railway station counters to avoid overcharging. " +
                "Avoid accepting food or drinks from strangers, especially during long train journeys. " +
                "Be cautious of your valuables in crowded pilgrimage sites and busy markets. " +
                "Ladies traveling alone should avoid deserted beaches and hillside trails after dark. " +
                "Carry personal medications, sunscreen, insect repellent, and a first-aid kit during wildlife visits. " +
                "The Tourist Police helpline 1800-425-4747 and Women Helpline 181 are available 24/7. " +
                "Respect local customs — dress modestly at temples, remove footwear before entering religious sites, " +
                "and avoid photographing devotees without permission.",
                "fas fa-shield-alt", "Safety"),

            new Guide(4L, "Best Time to Visit Tamil Nadu",
                "Tamil Nadu's climate is tropical and the best time to visit depends on the region you plan to explore. " +
                "October to March is the ideal time for most destinations, including beaches, temples, and wildlife sanctuaries, " +
                "when temperatures range from 20°C to 30°C with low humidity. " +
                "Hill stations like Ooty, Kodaikanal, and Yercaud are pleasantly cool throughout the year " +
                "but peak from April to June when plains tourists seek refuge from summer heat. " +
                "Monsoon season (June–September) brings lush greenery and full waterfalls in Courtallam and Hogenakkal, " +
                "but road conditions in hilly areas can be challenging. " +
                "December–January is peak festival season with Pongal celebrations, Mamallapuram Dance Festival, and " +
                "Madurai Float Festival offering cultural immersion. " +
                "Avoid visiting during the northeast monsoon (October–December) for coastal areas " +
                "as the state may experience cyclones from the Bay of Bengal.",
                "fas fa-calendar-alt", "Planning"),

            new Guide(5L, "Festivals & Cultural Events",
                "Tamil Nadu is the cultural capital of South India, celebrating a remarkable array of festivals " +
                "that reflect its ancient traditions and devotional spirit. " +
                "Pongal (January) is the most important harvest festival, celebrated with sugarcane, newly harvested rice, " +
                "kolam decorations, and jallikattu bull-taming events. " +
                "Karthigai Deepam (November/December) illuminates Tiruvannamalai with thousands of lamps " +
                "as the sacred flame is lit atop Arunachala Hill, visible for miles around. " +
                "The Chennai Music Season (December–January) is the world's largest classical music festival, " +
                "featuring over 2,000 Carnatic music concerts across the city. " +
                "Mahabalipuram Dance Festival showcases classical dance performances against the backdrop of " +
                "ancient rock sculptures with the full moon as a dramatic backdrop. " +
                "Thaipusam draws millions of devotees to Palani and other Murugan temples with kavadi processions. " +
                "Plan your visit around these festivals for an immersive cultural experience.",
                "fas fa-star", "Culture"),

            new Guide(6L, "Packing Guide for Tamil Nadu",
                "Packing smart for Tamil Nadu will greatly enhance your travel experience. " +
                "Lightweight, breathable cotton clothing in neutral colors is best for most of the year due to the warm climate. " +
                "Carry a light fleece or jacket if visiting hill stations (Ooty, Kodaikanal) even in summer " +
                "as nights can be quite cool. " +
                "Temple visits require modest dress — avoid sleeveless tops and short clothing; " +
                "carry a dupatta or sarong to cover up quickly. " +
                "Comfortable flat sandals that are easy to slip on and off are essential for temple visits. " +
                "A good raincoat or compact umbrella is useful from June to September. " +
                "Sunscreen (SPF 50+), sunglasses, and a wide-brimmed hat are non-negotiable for beach visits. " +
                "Carry a small backpack for day trips with essentials: water bottle, snacks, camera, power bank, " +
                "and a basic first-aid kit. Insect repellent is important for wildlife sanctuaries. " +
                "A small steel tumbler and spoon can be useful for enjoying roadside filter coffee the traditional way!",
                "fas fa-suitcase-rolling", "Planning"),

            new Guide(7L, "Language & Communication",
                "Tamil is the official language of Tamil Nadu and one of the world's oldest living Classical languages, " +
                "with a literary history dating back over 2,000 years. " +
                "While Tamil is predominantly spoken, English is widely understood in cities, tourist destinations, " +
                "hotels, and government offices. " +
                "Learning a few basic Tamil phrases will endear you greatly to locals: " +
                "'Vanakkam' (Hello/Namaste), 'Nandri' (Thank you), 'Enna vilai?' (What is the price?), " +
                "'Yenge irukku?' (Where is it?). " +
                "Hindi is understood to a limited extent but do not assume it will be spoken — " +
                "English is the preferred second language in Tamil Nadu. " +
                "Restaurant menus, signboards, and transport information are typically bilingual in Tamil and English. " +
                "Translation apps like Google Translate with Tamil support work excellently for real-time communication. " +
                "Locals are generally warm and helpful — a smile and respectful gesture goes a long way.",
                "fas fa-language", "Culture"),

            new Guide(8L, "Shopping in Tamil Nadu",
                "Tamil Nadu is a shopper's paradise with distinctive handicrafts, textiles, and artisanal products " +
                "unique to each region. " +
                "Kancheepuram Silk Sarees are the most prized possession a shopper can acquire — " +
                "woven with pure mulberry silk and gold zari threads, they are heirloom-quality investments. " +
                "Tanjore paintings, bronze Chola sculptures, wooden toys from Thanjavur, and terracotta artifacts " +
                "from Mahabalipuram make wonderful souvenirs. " +
                "Chettinad tiles and antique furniture are sought after interior design elements. " +
                "Nilgiri Tea varieties from Ooty and Kodaikanal tea gardens are among India's finest cup teas. " +
                "Spices — especially star anise, kalpasi, and marathi mokku from Chettinad — are " +
                "fragrant and flavorful additions to any food lover's collection. " +
                "Government-run Poompuhar showrooms across the state offer authentic handicrafts at fixed prices, " +
                "ideal for budget-conscious shoppers who want to avoid bargaining.",
                "fas fa-shopping-bag", "Lifestyle"),

            new Guide(9L, "Health & Medical Tips",
                "Maintaining good health while traveling in Tamil Nadu requires simple precautions. " +
                "Drink only bottled or filtered water — avoid tap water and ice from unknown sources. " +
                "Eat freshly cooked hot food; the vibrant street food scene is wonderful but choose " +
                "popular stalls with high turnover to ensure freshness. " +
                "Food-borne illnesses can be avoided by washing hands frequently — carry a small hand sanitizer. " +
                "Protect yourself from mosquito-borne diseases (dengue, malaria) especially during and after monsoon: " +
                "use repellent creams, sleep under mosquito nets in rural guesthouses, and carry Malarone if visiting wildlife sanctuaries. " +
                "The summer heat (April–June) can cause heat exhaustion — stay hydrated, wear light clothing, " +
                "and avoid strenuous outdoor activities between 11 AM and 3 PM. " +
                "Apollo Hospitals, Fortis, and Government District Hospitals provide excellent medical care across the state. " +
                "The government runs free medical services at Primary Health Centers in rural areas. " +
                "Carry a basic travel pharmacy: ORS sachets, anti-diarrheal, antihistamine, paracetamol, and bandages.",
                "fas fa-heartbeat", "Health"),

            new Guide(10L, "Eco-Tourism & Responsible Travel",
                "Tamil Nadu is home to extraordinary biodiversity — from the Nilgiris Biosphere Reserve to " +
                "the Gulf of Mannar coral reefs — making responsible travel practices essential. " +
                "Always stay on designated trails in wildlife sanctuaries and follow ranger instructions. " +
                "Never feed wild animals and maintain safe distances; flash photography disturbs wildlife. " +
                "Carry a reusable water bottle and cloth bag to minimize plastic waste in natural areas. " +
                "Participate in community-based tourism programs in tribal villages with proper local guides " +
                "to support livelihoods while learning authentic traditions. " +
                "Choose certified eco-resorts and lodges that practice waste management and renewable energy use. " +
                "Do not pick flowers, remove corals, or disturb nesting birds in marine parks. " +
                "The Tamil Nadu Forest Department runs excellent nature education programs at forest stations — " +
                "participating in these supports conservation awareness. " +
                "Support local artisans by purchasing handmade products directly from craftspeople rather than middlemen.",
                "fas fa-leaf", "Environment")
        );
    }

    /**
     * Find a single guide by its ID.
     */
    public Optional<Guide> getGuideById(Long id) {
        return getAllGuides().stream()
                .filter(g -> g.getId().equals(id))
                .findFirst();
    }

    // =========================================================================
    // STATISTICS (for homepage)
    // =========================================================================

    public int getTotalAttractions() { return getAllAttractions().size(); }
    public int getTotalHotels() { return getAllHotels().size(); }
    public int getTotalGuides() { return getAllGuides().size(); }
}
