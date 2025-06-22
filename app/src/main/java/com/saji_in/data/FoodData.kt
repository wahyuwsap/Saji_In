package com.saji_in.data

import com.saji_in.R
import com.saji_in.model.FoodItem
import com.saji_in.model.FoodType

val foodList = listOf(
    FoodItem(
        title = "Popcorn Caramel",
        description = "Manis legit, crunchy terus!",
        imageResId = R.drawable.popcorn,
        cookTime = "15 Mins",
        ingredients = listOf(
            "Jagung" to "100 gram",
            "Gula" to "3 sdm",
            "Mentega" to "2 sdm"
        ),
        steps = listOf(
            "Panaskan mentega di wajan.",
            "Masukkan jagung dan tutup wajan.",
            "Tunggu hingga semua jagung meletup menjadi popcorn.",
            "Lelehkan gula hingga menjadi karamel.",
            "Campurkan popcorn dengan karamel, aduk rata."
        ),
        type = FoodType.JAJANAN,
        servingSize = "2 porsi"
    ),
    FoodItem(
        title = "Kue Cubit Topping",
        description = "Lumer, manis, seru banget",
        imageResId = R.drawable.kue_cubit,
        cookTime = "15 Mins",
        ingredients = listOf(
            "Tepung" to "100 gram",
            "Telur" to "2 butir",
            "Coklat" to "50 gram",
            "Meses" to "secukupnya"
        ),
        steps = listOf(
            "Campurkan tepung, telur, dan coklat hingga rata.",
            "Tuang adonan ke cetakan kue cubit.",
            "Tambahkan meses di atas adonan.",
            "Masak dengan api kecil hingga matang.",
            "Angkat dan sajikan hangat."
        ),
        type = FoodType.MAKANAN,
        servingSize = "2 porsi"
    ),
    FoodItem(
        title = "Spaghetti",
        description = "Gak usah fancy, cukup spaghetti carbonara buat manjain lidah",
        imageResId = R.drawable.spageti,
        cookTime = "15 Mins",
        ingredients = listOf(
            "Spaghetti" to "150 gram",
            "Daging asap" to "100 gram",
            "Susu" to "100 ml",
            "Keju parut" to "50 gram"
        ),
        steps = listOf(
            "Rebus spaghetti hingga matang.",
            "Tumis daging asap hingga harum.",
            "Tambahkan susu dan keju, aduk rata.",
            "Masukkan spaghetti dan aduk hingga meresap.",
            "Sajikan dengan taburan keju."
        ),
        type = FoodType.MAKANAN,
        servingSize = "2 porsi"
    ),
    FoodItem(
        title = "Chicken Katsu",
        description = "Gak perlu ke Jepang, cukup chicken katsu di piring kamu!",
        imageResId = R.drawable.chicken_katsu,
        cookTime = "20 Mins",
        ingredients = listOf(
            "Dada ayam" to "200 gram",
            "Tepung roti" to "100 gram",
            "Telur" to "1 butir",
            "Minyak goreng" to "secukupnya"
        ),
        steps = listOf(
            "Iris dan pipihkan dada ayam.",
            "Balur ayam dengan tepung, telur, dan tepung roti.",
            "Panaskan minyak dan goreng ayam hingga keemasan.",
            "Tiriskan dan sajikan dengan saus."
        ),
        type = FoodType.MAKANAN,
        servingSize = "2 porsi"
    ),
    FoodItem(
        title = "Risoles Ayam",
        description = "Renyaah, gurih, isi melimpah!",
        imageResId = R.drawable.risoles,
        cookTime = "45 Mins",
        ingredients = listOf(
            "Kulit risoles" to "10 lembar",
            "Ayam suwir" to "150 gram",
            "Wortel parut" to "1 buah",
            "Susu cair" to "50 ml"
        ),
        steps = listOf(
            "Tumis ayam dan wortel, tuang susu, masak hingga kering.",
            "Isi kulit risoles dengan isian ayam.",
            "Gulung dan rekatkan tepinya.",
            "Goreng hingga keemasan."
        ),
        type = FoodType.JAJANAN,
        servingSize = "2 porsi"
    ),
    FoodItem(
        title = "Keripik Keju Pedas",
        description = "Sarapan spesial, tapi tetap murah",
        imageResId = R.drawable.keripik_keju,
        cookTime = "10 Mins",
        ingredients = listOf(
            "Tepung terigu" to "100 gram",
            "Keju parut" to "50 gram",
            "Cabai bubuk" to "1 sdm"
        ),
        steps = listOf(
            "Campur semua bahan hingga kalis.",
            "Gilas adonan tipis, potong sesuai selera.",
            "Goreng dalam minyak panas hingga kering.",
            "Tiriskan dan sajikan."
        ),
        type = FoodType.JAJANAN,
        servingSize = "2 porsi"
    ),
    FoodItem(
        title = "Tumis Kangkung",
        description = "Kangen masakan rumahan? Tumis kangkung bisa obatin rindu!",
        imageResId = R.drawable.tumis_kangkung,
        cookTime = "10 Mins",
        ingredients = listOf(
            "Kangkung" to "1 ikat",
            "Bawang putih" to "2 siung",
            "Cabai merah" to "3 buah",
            "Minyak goreng" to "2 sdm"
        ),
        steps = listOf(
            "Iris bawang dan cabai, tumis hingga harum.",
            "Masukkan kangkung, aduk cepat.",
            "Tambahkan sedikit air dan garam.",
            "Masak hingga layu, sajikan segera."
        ),
        type = FoodType.MAKANAN,
        servingSize = "2 porsi"
    ),
    FoodItem(
        title = "Nasi Kuning",
        description = "Sarapan spesial tapi tetep ramah di kantong",
        imageResId = R.drawable.nasi_kuning,
        cookTime = "45 Mins",
        ingredients = listOf(
            "Beras" to "2 gelas",
            "Santan" to "400 ml",
            "Kunyit" to "1 ruas, haluskan",
            "Daun salam" to "2 lembar"
        ),
        steps = listOf(
            "Cuci beras, masukkan ke dalam rice cooker.",
            "Tambahkan santan, kunyit, dan daun salam.",
            "Masak hingga nasi matang dan kuning merata.",
            "Sajikan dengan lauk favorit."
        ),
        type = FoodType.MAKANAN,
        servingSize = "2 porsi"
    ),
    FoodItem(
        title = "Nasi Goreng",
        description = "Cocok buat kamu yang pengen kenyang tapi ga ribet",
        imageResId = R.drawable.nasi_goreng,
        cookTime = "15 Mins",
        ingredients = listOf(
            "Nasi putih" to "1 piring",
            "Telur" to "1 butir",
            "Kecap manis" to "1 sdm",
            "Bumbu halus" to "secukupnya"
        ),
        steps = listOf(
            "Tumis bumbu halus hingga harum.",
            "Masukkan telur, orak-arik.",
            "Tambahkan nasi putih dan kecap.",
            "Aduk rata dan sajikan hangat."
        ),
        type = FoodType.MAKANAN,
        servingSize = "2 porsi"
    ),
    FoodItem(
        title = "Telur Dadar",
        description = "Buat kamu yang suka hemat tapi tetep pengen nikmat",
        imageResId = R.drawable.telur_dadar,
        cookTime = "10 Mins",
        ingredients = listOf(
            "Telur" to "2 butir",
            "Daun bawang" to "1 batang",
            "Garam" to "secukupnya",
            "Minyak goreng" to "1 sdm"
        ),
        steps = listOf(
            "Kocok telur dengan garam dan daun bawang.",
            "Panaskan minyak di wajan.",
            "Tuang adonan telur, ratakan.",
            "Masak kedua sisi hingga matang."
        ),
        type = FoodType.MAKANAN,
        servingSize = "2 porsi"
    ),








    FoodItem(
        title = "Pisang Goreng",
        description = "Camilan sore hari yang manis dan renyah",
        imageResId = R.drawable.pisang_goreng,
        cookTime = "15 Mins",
        ingredients = listOf(
            "Pisang kepok" to "5 buah",
            "Tepung terigu" to "100 gram",
            "Gula pasir" to "1 sdm",
            "Air" to "100 ml",
            "Minyak goreng" to "secukupnya"
        ),
        steps = listOf(
            "Campur tepung, gula, dan air hingga jadi adonan.",
            "Celupkan pisang ke dalam adonan.",
            "Panaskan minyak dan goreng pisang sampai keemasan.",
            "Angkat dan tiriskan."
        ),
        type = FoodType.JAJANAN,
        servingSize = "5 buah"
    ),
    FoodItem(
        title = "Sate Ayam",
        description = "Makanan khas Indonesia dengan cita rasa bumbu kacang",
        imageResId = R.drawable.sate_ayam,
        cookTime = "30 Mins",
        ingredients = listOf(
            "Daging ayam" to "250 gram",
            "Tusuk sate" to "10 batang",
            "Bumbu kacang" to "secukupnya",
            "Kecap manis" to "2 sdm",
            "Jeruk limau" to "1 buah"
        ),
        steps = listOf(
            "Potong ayam dan tusuk dengan tusuk sate.",
            "Bakar sate sambil dioles kecap manis.",
            "Sajikan dengan bumbu kacang dan jeruk limau."
        ),
        type = FoodType.MAKANAN,
        servingSize = "10 tusuk"
    ),
    FoodItem(
        title = "Jus Alpukat",
        description = "Minuman sehat dan mengenyangkan, cocok untuk diet",
        imageResId = R.drawable.jus_alpukat,
        cookTime = "7 Mins",
        ingredients = listOf(
            "Alpukat matang" to "1 buah",
            "Susu kental manis" to "2 sdm",
            "Air matang" to "100 ml",
            "Es batu" to "secukupnya"
        ),
        steps = listOf(
            "Kerok alpukat dan masukkan ke blender.",
            "Tambahkan susu, air, dan es batu.",
            "Blender hingga halus.",
            "Sajikan dalam gelas."
        ),
        type = FoodType.MINUMAN,
        servingSize = "1 gelas"
    ),
    FoodItem(
        title = "Bakwan Sayur",
        description = "Camilan goreng renyah berisi sayuran, cocok untuk teman teh",
        imageResId = R.drawable.bakwan_sayur,
        cookTime = "20 Mins",
        ingredients = listOf(
            "Kol" to "50 gram, diiris tipis",
            "Wortel" to "1 buah, diparut kasar",
            "Daun bawang" to "1 batang",
            "Tepung terigu" to "100 gram",
            "Air" to "150 ml",
            "Garam dan merica" to "secukupnya",
            "Minyak goreng" to "secukupnya"
        ),
        steps = listOf(
            "Campur semua bahan dalam satu wadah.",
            "Aduk hingga menjadi adonan kental.",
            "Panaskan minyak dan goreng adonan satu per satu.",
            "Goreng hingga keemasan lalu tiriskan."
        ),
        type = FoodType.JAJANAN,
        servingSize = "10 buah"
    ),
    FoodItem(
        title = "Klepon",
        description = "Jajanan pasar isi gula merah yang meledak di mulut",
        imageResId = R.drawable.klepon,
        cookTime = "30 Mins",
        ingredients = listOf(
            "Tepung ketan" to "150 gram",
            "Air daun pandan" to "100 ml",
            "Gula merah" to "100 gram, serut halus",
            "Kelapa parut" to "secukupnya",
            "Garam" to "sejumput"
        ),
        steps = listOf(
            "Campur tepung dan air pandan hingga kalis.",
            "Ambil adonan, isi dengan gula merah, bulatkan.",
            "Rebus dalam air mendidih hingga mengapung.",
            "Gulingkan ke kelapa parut yang telah dikukus."
        ),
        type = FoodType.JAJANAN,
        servingSize = "10 butir"
    ),
    FoodItem(
        title = "Wedang Jahe",
        description = "Minuman tradisional hangat yang menyehatkan tubuh",
        imageResId = R.drawable.wedang_jahe,
        cookTime = "15 Mins",
        ingredients = listOf(
            "Jahe" to "2 ruas, geprek",
            "Air" to "300 ml",
            "Gula merah" to "2 sdm",
            "Serai" to "1 batang, memarkan"
        ),
        steps = listOf(
            "Rebus air dengan jahe dan serai hingga mendidih.",
            "Masukkan gula merah dan aduk hingga larut.",
            "Saring dan sajikan hangat."
        ),
        type = FoodType.MINUMAN,
        servingSize = "1 gelas"
    ),
    FoodItem(
        title = "Puding Coklat",
        description = "Dessert dingin favorit keluarga dengan rasa manis legit",
        imageResId = R.drawable.puding_coklat,
        cookTime = "20 Mins + dinginkan",
        ingredients = listOf(
            "Agar-agar bubuk coklat" to "1 bungkus",
            "Susu cair" to "500 ml",
            "Gula pasir" to "100 gram",
            "Dark chocolate" to "50 gram"
        ),
        steps = listOf(
            "Campurkan semua bahan ke dalam panci.",
            "Masak sambil diaduk hingga mendidih.",
            "Tuang ke cetakan, diamkan hingga mengeras.",
            "Sajikan dingin."
        ),
        type = FoodType.JAJANAN,
        servingSize = "4 porsi"
    ),
    FoodItem(
        title = "Tempe Mendoan",
        description = "Tempe goreng setengah matang dengan tepung berbumbu",
        imageResId = R.drawable.tempe_mendoan,
        cookTime = "10 Mins",
        ingredients = listOf(
            "Tempe tipis lebar" to "5 lembar",
            "Tepung terigu" to "100 gram",
            "Daun bawang" to "1 batang, iris",
            "Bawang putih" to "2 siung, haluskan",
            "Ketumbar" to "1/2 sdt",
            "Air" to "150 ml",
            "Garam" to "secukupnya",
            "Minyak goreng" to "secukupnya"
        ),
        steps = listOf(
            "Campurkan semua bahan kecuali tempe.",
            "Masukkan tempe ke dalam adonan.",
            "Goreng dalam minyak panas sebentar saja.",
            "Angkat saat bagian luar sudah terlihat matang."
        ),
        type = FoodType.JAJANAN,
        servingSize = "5 lembar"
    ),
    FoodItem(
        title = "Es Cendol",
        description = "Minuman manis, dingin, dan menyegarkan khas Indonesia",
        imageResId = R.drawable.es_cendol,
        cookTime = "20 Mins",
        ingredients = listOf(
            "Cendol" to "100 gram",
            "Santan" to "200 ml, rebus dengan sejumput garam",
            "Gula merah" to "150 gram, larutkan dengan air",
            "Es batu" to "secukupnya"
        ),
        steps = listOf(
            "Siapkan gelas dan isi dengan cendol.",
            "Tuang gula merah cair lalu santan.",
            "Tambahkan es batu secukupnya.",
            "Aduk dan sajikan segera."
        ),
        type = FoodType.MINUMAN,
        servingSize = "2 gelas"
    ),
    FoodItem(
        title = "Perkedel Kentang",
        description = "Lauk pelengkap nikmat, cocok untuk nasi dan sayur",
        imageResId = R.drawable.perkedel_kentang,
        cookTime = "25 Mins",
        ingredients = listOf(
            "Kentang" to "3 buah, rebus dan haluskan",
            "Bawang goreng" to "1 sdm",
            "Telur" to "1 butir",
            "Merica & garam" to "secukupnya",
            "Daun seledri" to "1 batang, iris halus",
            "Minyak goreng" to "secukupnya"
        ),
        steps = listOf(
            "Campurkan semua bahan kecuali telur.",
            "Bentuk bulat pipih dan celupkan ke telur.",
            "Goreng hingga kuning keemasan.",
            "Tiriskan dan siap disajikan."
        ),
        type = FoodType.MAKANAN,
        servingSize = "5 buah"
    ),
    FoodItem(
        title = "Teh Tarik",
        description = "Minuman teh dengan susu yang ditarik berulang hingga berbusa",
        imageResId = R.drawable.teh_tarik,
        cookTime = "10 Mins",
        ingredients = listOf(
            "Teh hitam" to "2 kantong",
            "Air panas" to "200 ml",
            "Susu kental manis" to "2 sdm"
        ),
        steps = listOf(
            "Seduh teh hitam dengan air panas.",
            "Tambahkan susu kental manis.",
            "Tuang bolak-balik antara dua gelas hingga berbusa.",
            "Sajikan selagi hangat atau dengan es."
        ),
        type = FoodType.MINUMAN,
        servingSize = "1 gelas"
    ),
    FoodItem(
        title = "Ayam Geprek",
        description = "Ayam goreng tepung yang digeprek dengan sambal pedas",
        imageResId = R.drawable.ayam_geprek,
        cookTime = "30 Mins",
        ingredients = listOf(
            "Dada ayam fillet" to "2 potong",
            "Tepung serbaguna" to "100 gram",
            "Bawang putih" to "3 siung",
            "Cabe rawit merah" to "10 buah",
            "Minyak goreng" to "secukupnya",
            "Garam" to "secukupnya"
        ),
        steps = listOf(
            "Balur ayam dengan tepung dan goreng hingga matang.",
            "Ulek cabe rawit dan bawang, tambahkan garam.",
            "Letakkan ayam di atas sambal, geprek hingga menyatu.",
            "Sajikan dengan nasi hangat."
        ),
        type = FoodType.MAKANAN,
        servingSize = "2 porsi"
    ),
    FoodItem(
        title = "Rendang",
        description = "Masakan khas Minang yang kaya rempah dan dimasak hingga kering",
        imageResId = R.drawable.rendang,
        cookTime = "3 Jam",
        ingredients = listOf(
            "Daging sapi" to "500 gram",
            "Santan kental" to "1 liter",
            "Serai" to "2 batang",
            "Daun kunyit" to "1 lembar",
            "Daun jeruk" to "3 lembar",
            "Bumbu halus (bawang merah, bawang putih, cabai merah, jahe, lengkuas, kunyit)" to "secukupnya",
            "Garam & gula" to "secukupnya"
        ),
        steps = listOf(
            "Tumis bumbu halus hingga harum.",
            "Masukkan daging dan aduk rata.",
            "Tuang santan dan masukkan daun-daunan.",
            "Masak dengan api kecil hingga kuah menyusut dan mengering.",
            "Aduk terus hingga rendang berwarna coklat gelap dan berminyak."
        ),
        type = FoodType.MAKANAN,
        servingSize = "4 porsi"
    ),
    FoodItem(
        title = "Dendeng Balado",
        description = "Irisan daging tipis goreng dengan sambal balado khas Minang",
        imageResId = R.drawable.dendeng_balado,
        cookTime = "45 Mins",
        ingredients = listOf(
            "Daging sapi" to "300 gram, iris tipis dan rebus",
            "Cabai merah keriting" to "10 buah",
            "Bawang merah" to "5 butir",
            "Tomat" to "1 buah",
            "Garam & gula" to "secukupnya",
            "Minyak goreng" to "secukupnya"
        ),
        steps = listOf(
            "Iris tipis daging lalu goreng hingga kering.",
            "Haluskan cabai, bawang, dan tomat, lalu tumis hingga matang.",
            "Masukkan dendeng ke sambal dan aduk rata.",
            "Sajikan hangat."
        ),
        type = FoodType.MAKANAN,
        servingSize = "3 porsi"
    ),
    FoodItem(
        title = "Ayam Pop",
        description = "Ayam rebus khas Padang dengan rasa gurih dan sambal segar",
        imageResId = R.drawable.ayam_pop,
        cookTime = "45 Mins",
        ingredients = listOf(
            "Ayam potong" to "4 potong",
            "Bawang putih" to "3 siung, haluskan",
            "Air kelapa" to "500 ml",
            "Daun salam & serai" to "masing-masing 1 lembar/batang",
            "Garam" to "secukupnya",
            "Minyak untuk menggoreng sebentar" to "secukupnya"
        ),
        steps = listOf(
            "Rebus ayam dengan bawang, air kelapa, dan rempah hingga empuk.",
            "Angkat, tiriskan, dan goreng sebentar (jangan sampai kering).",
            "Sajikan dengan sambal merah segar."
        ),
        type = FoodType.MAKANAN,
        servingSize = "4 porsi"
    ),
    FoodItem(
        title = "Es Cincau Hijau",
        description = "Minuman segar tradisional dengan cincau hijau dan kuah santan manis",
        imageResId = R.drawable.es_cincau,
        cookTime = "20 Mins",
        ingredients = listOf(
            "Cincau hijau" to "200 gram, potong dadu",
            "Santan" to "300 ml (dari ½ butir kelapa)",
            "Daun pandan" to "1 lembar",
            "Gula merah" to "100 gram, serut halus",
            "Air" to "200 ml",
            "Es batu" to "secukupnya",
            "Garam" to "¼ sdt"
        ),
        steps = listOf(
            "Masak gula merah, daun pandan, dan air hingga larut, lalu saring dan dinginkan.",
            "Rebus santan dengan garam sambil terus diaduk agar tidak pecah, lalu dinginkan.",
            "Siapkan cincau dalam gelas, tuang sirup gula merah dan santan, tambahkan es batu.",
            "Aduk rata dan sajikan dingin."
        ),
        type = FoodType.MINUMAN,
        servingSize = "4 gelas"
    ),

    FoodItem(
        title = "Es Kelapa Muda",
        description = "Minuman tropis segar dari kelapa muda asli",
        imageResId = R.drawable.es_kelapa,
        cookTime = "5 Mins",
        ingredients = listOf(
            "Daging kelapa muda" to "200 gram",
            "Air kelapa muda" to "500 ml",
            "Sirup cocopandan" to "2 sdm",
            "Es batu" to "secukupnya"
        ),
        steps = listOf(
            "Masukkan daging kelapa ke gelas.",
            "Tuang air kelapa dan sirup cocopandan.",
            "Tambahkan es batu.",
            "Aduk dan sajikan segera."
        ),
        type = FoodType.MINUMAN,
        servingSize = "2 gelas"
    ),

    FoodItem(
        title = "Dalgona Coffee",
        description = "Kopi viral dengan krim kopi kocok di atas susu dingin",
        imageResId = R.drawable.dalgona_coffee,
        cookTime = "10 Mins",
        ingredients = listOf(
            "Kopi instan" to "2 sdm",
            "Gula pasir" to "2 sdm",
            "Air panas" to "2 sdm",
            "Susu cair dingin" to "200 ml",
            "Es batu" to "secukupnya"
        ),
        steps = listOf(
            "Kocok kopi, gula, dan air panas hingga mengembang dan kental.",
            "Masukkan es batu ke dalam gelas, tuang susu.",
            "Letakkan krim kopi di atas susu.",
            "Aduk saat akan diminum."
        ),
        type = FoodType.MINUMAN,
        servingSize = "1 gelas"
    ),

    FoodItem(
        title = "Es Soda Gembira",
        description = "Minuman manis menyegarkan dengan kombinasi sirup dan soda",
        imageResId = R.drawable.soda_gembira,
        cookTime = "5 Mins",
        ingredients = listOf(
            "Sirup merah (cocopandan)" to "3 sdm",
            "Susu kental manis" to "2 sdm",
            "Soda tawar dingin" to "1 kaleng",
            "Es batu" to "secukupnya"
        ),
        steps = listOf(
            "Tuang sirup dan susu ke dalam gelas.",
            "Tambahkan es batu.",
            "Tuang soda secara perlahan.",
            "Aduk sebelum diminum."
        ),
        type = FoodType.MINUMAN,
        servingSize = "1 gelas"
    ),

    FoodItem(
        title = "Es Buah Segar",
        description = "Minuman sehat berisi potongan buah segar dengan kuah manis",
        imageResId = R.drawable.es_buahjpg,
        cookTime = "15 Mins",
        ingredients = listOf(
            "Semangka, melon, pepaya" to "masing-masing 100 gram, potong dadu",
            "Susu kental manis" to "2 sdm",
            "Sirup vanila" to "2 sdm",
            "Air matang" to "300 ml",
            "Es batu" to "secukupnya"
        ),
        steps = listOf(
            "Campur potongan buah dalam mangkuk besar.",
            "Tambahkan susu, sirup, dan air.",
            "Masukkan es batu dan aduk rata.",
            "Sajikan dalam gelas."
        ),
        type = FoodType.MINUMAN,
        servingSize = "3-4 gelas"
    ),

    FoodItem(
        title = "Matcha Latte",
        description = "Minuman hijau khas Jepang dengan aroma teh yang lembut dan creamy",
        imageResId = R.drawable.matcha_latte,
        cookTime = "10 Mins",
        ingredients = listOf(
            "Bubuk matcha" to "1 sdt",
            "Air panas" to "50 ml",
            "Susu cair" to "200 ml",
            "Susu kental manis atau gula cair" to "secukupnya",
            "Es batu" to "secukupnya"
        ),
        steps = listOf(
            "Larutkan bubuk matcha dengan air panas, aduk hingga tidak menggumpal.",
            "Tuang susu dan pemanis ke gelas, tambahkan es batu.",
            "Tuang larutan matcha di atasnya perlahan untuk efek layer.",
            "Aduk sebelum diminum."
        ),
        type = FoodType.MINUMAN,
        servingSize = "1 gelas"
    ),

    FoodItem(
        title = "Strawberry Yakult Sparkling",
        description = "Minuman soda ringan dengan rasa asam segar dan strawberry manis",
        imageResId = R.drawable.yakult_sparkling,
        cookTime = "5 Mins",
        ingredients = listOf(
            "Yakult" to "1 botol",
            "Soda tawar (Sprite atau soda water)" to "200 ml",
            "Sirup strawberry" to "2 sdm",
            "Es batu" to "secukupnya"
        ),
        steps = listOf(
            "Masukkan sirup strawberry ke dalam gelas.",
            "Tambahkan es batu dan yakult.",
            "Tuang soda perlahan di atasnya.",
            "Aduk dan sajikan segera."
        ),
        type = FoodType.MINUMAN,
        servingSize = "1 gelas"
    ),

    FoodItem(
        title = "Oreo Milkshake",
        description = "Minuman manis dan creamy dengan rasa khas biskuit Oreo",
        imageResId = R.drawable.oreo_milkshake,
        cookTime = "10 Mins",
        ingredients = listOf(
            "Oreo" to "5 keping",
            "Es krim vanila" to "2 scoop",
            "Susu cair" to "200 ml",
            "Es batu" to "secukupnya",
            "Whipped cream (opsional)" to "secukupnya"
        ),
        steps = listOf(
            "Blender oreo, es krim, susu, dan es batu hingga halus.",
            "Tuang ke dalam gelas.",
            "Tambahkan whipped cream dan remah oreo di atasnya jika suka.",
            "Sajikan dingin."
        ),
        type = FoodType.MINUMAN,
        servingSize = "1 gelas"
    ),

    FoodItem(
        title = "Cireng Isi Pedas",
        description = "Camilan kenyal dari aci dengan isian ayam pedas yang gurih",
        imageResId = R.drawable.cireng_isi,
        cookTime = "45 Mins",
        ingredients = listOf(
            "Tepung tapioka" to "250 gram",
            "Bawang putih halus" to "2 siung",
            "Daun bawang iris" to "1 batang",
            "Air panas" to "200 ml",
            "Isian ayam suwir pedas" to "secukupnya",
            "Garam & merica" to "secukupnya",
            "Minyak goreng" to "secukupnya"
        ),
        steps = listOf(
            "Campur tapioka, bawang, daun bawang, dan bumbu. Tambahkan air panas sedikit demi sedikit hingga adonan kalis.",
            "Ambil sedikit adonan, pipihkan dan beri isian ayam.",
            "Bulatkan dan rekatkan, lalu goreng hingga kecoklatan.",
            "Sajikan hangat."
        ),
        type = FoodType.JAJANAN,
        servingSize = "10 buah"
    ),

    FoodItem(
        title = "Piscok (Pisang Coklat)",
        description = "Pisang matang dibalut kulit lumpia dengan lelehan coklat lumer",
        imageResId = R.drawable.piscok,
        cookTime = "20 Mins",
        ingredients = listOf(
            "Pisang kepok matang" to "4 buah",
            "Coklat batang atau meses" to "secukupnya",
            "Kulit lumpia" to "8 lembar",
            "Minyak goreng" to "secukupnya"
        ),
        steps = listOf(
            "Potong pisang jadi dua memanjang, letakkan di kulit lumpia bersama coklat.",
            "Gulung dan rekatkan ujungnya.",
            "Goreng hingga kulit lumpia kecoklatan dan renyah.",
            "Sajikan hangat dengan tambahan susu coklat jika suka."
        ),
        type = FoodType.JAJANAN,
        servingSize = "8 piscok"
    ),

    FoodItem(
        title = "Sosis Gulung Mie",
        description = "Sosis dibungkus mie instan, renyah di luar dan juicy di dalam",
        imageResId = R.drawable.sosis_mie,
        cookTime = "20 Mins",
        ingredients = listOf(
            "Sosis sapi atau ayam" to "5 buah, potong dua",
            "Mie instan" to "1 bungkus, direbus setengah matang",
            "Telur" to "1 butir",
            "Minyak goreng" to "secukupnya"
        ),
        steps = listOf(
            "Balurkan mie pada sosis hingga tertutup rata.",
            "Celupkan ke telur kocok.",
            "Goreng dalam minyak panas hingga keemasan.",
            "Sajikan hangat dengan saus sambal."
        ),
        type = FoodType.JAJANAN,
        servingSize = "10 tusuk"
    ),

    FoodItem(
        title = "Roti Bakar Coklat Keju",
        description = "Snack malam favorit dengan isian coklat leleh dan keju parut",
        imageResId = R.drawable.roti_bakar,
        cookTime = "15 Mins",
        ingredients = listOf(
            "Roti tawar" to "4 lembar",
            "Margarine" to "2 sdm",
            "Meses coklat" to "secukupnya",
            "Keju parut" to "secukupnya",
            "Susu kental manis" to "secukupnya"
        ),
        steps = listOf(
            "Olesi roti dengan margarin lalu panggang di teflon hingga kecoklatan.",
            "Tambahkan meses dan keju di dalamnya, lipat roti.",
            "Panggang kembali sebentar hingga isian meleleh.",
            "Potong dan beri topping susu kental manis."
        ),
        type = FoodType.MAKANAN,
        servingSize = "2 porsi"
    ),
    FoodItem(
        title = "Cheesy Garlic Bread",
        description = "Roti panggang lumer dengan aroma bawang putih dan keju meleleh",
        imageResId = R.drawable.garlic_bread,
        cookTime = "20 Mins",
        ingredients = listOf(
            "Roti tawar tebal atau baguette" to "4 potong",
            "Butter cair" to "2 sdm",
            "Bawang putih cincang" to "2 siung",
            "Keju mozzarella" to "secukupnya",
            "Peterseli cincang" to "opsional"
        ),
        steps = listOf(
            "Campur butter dengan bawang putih, oleskan ke roti.",
            "Taburi keju mozzarella di atasnya.",
            "Panggang di oven atau teflon hingga keju meleleh dan permukaan garing.",
            "Taburi peterseli dan sajikan."
        ),
        type = FoodType.MAKANAN,
        servingSize = "4 potong"
    ),
    FoodItem(
        title = "Churros Coklat",
        description = "Camilan goreng ala Spanyol dengan taburan gula kayu manis dan saus coklat",
        imageResId = R.drawable.churros,
        cookTime = "30 Mins",
        ingredients = listOf(
            "Tepung terigu" to "125 gram",
            "Air" to "250 ml",
            "Butter" to "50 gram",
            "Gula" to "1 sdm",
            "Telur" to "1 butir",
            "Gula halus dan kayu manis bubuk" to "untuk taburan",
            "Saus coklat leleh" to "secukupnya"
        ),
        steps = listOf(
            "Didihkan air, butter, dan gula. Masukkan tepung, aduk cepat hingga kalis.",
            "Angkat, dinginkan sedikit, lalu masukkan telur. Aduk rata.",
            "Masukkan ke piping bag, semprot ke minyak panas, goreng hingga keemasan.",
            "Tiriskan dan balur dengan gula + kayu manis.",
            "Sajikan dengan saus coklat."
        ),
        type = FoodType.MAKANAN,
        servingSize = "12 churros"
    ),
    FoodItem(
        title = "Otak-Otak Goreng",
        description = "Camilan ikan tenggiri khas, digoreng renyah dan cocok dicocol saus",
        imageResId = R.drawable.otak_otak,
        cookTime = "45 Mins",
        ingredients = listOf(
            "Ikan tenggiri giling" to "250 gram",
            "Tepung sagu" to "100 gram",
            "Bawang putih halus" to "2 siung",
            "Putih telur" to "1 butir",
            "Garam dan lada" to "secukupnya",
            "Daun bawang" to "1 batang, iris",
            "Minyak goreng" to "secukupnya"
        ),
        steps = listOf(
            "Campur semua bahan hingga kalis dan bisa dibentuk.",
            "Ambil adonan, bentuk lonjong kecil.",
            "Goreng hingga kuning keemasan.",
            "Sajikan dengan saus sambal atau cuko."
        ),
        type = FoodType.MAKANAN,
        servingSize = "15 otak-otak"
    ),
    FoodItem(
        title = "Telur Gulung",
        description = "Snack jajanan SD yang viral kembali, digulung di tusuk sate",
        imageResId = R.drawable.telur_gulung,
        cookTime = "20 Mins",
        ingredients = listOf(
            "Telur ayam" to "3 butir",
            "Air" to "3 sdm",
            "Garam dan kaldu bubuk" to "secukupnya",
            "Minyak goreng banyak (deep fry)" to "secukupnya",
            "Tusuk sate" to "10 buah"
        ),
        steps = listOf(
            "Kocok telur, beri air dan bumbu, aduk hingga berbusa.",
            "Panaskan minyak banyak hingga benar-benar panas.",
            "Tuang 1 sendok adonan, segera gulung dengan tusuk sate dari sisi bawah.",
            "Angkat dan tiriskan.",
            "Sajikan dengan saus sambal."
        ),
        type = FoodType.MAKANAN,
        servingSize = "10 gulungan"
    ),
    FoodItem(
        title = "Kastengel",
        description = "Kue kering keju asin gurih khas Lebaran, tapi cocok kapan aja",
        imageResId = R.drawable.kastengel,
        cookTime = "60 Mins",
        ingredients = listOf(
            "Tepung terigu" to "250 gram",
            "Keju cheddar parut" to "150 gram",
            "Margarin" to "200 gram",
            "Kuning telur" to "2 butir",
            "Susu bubuk" to "2 sdm",
            "Kuning telur untuk olesan" to "1 butir"
        ),
        steps = listOf(
            "Kocok margarin dan kuning telur, masukkan keju, susu, dan tepung.",
            "Uleni, gilas, dan potong bentuk persegi.",
            "Letakkan di loyang, oles kuning telur dan taburi keju.",
            "Panggang 150°C selama 25–30 menit hingga matang.",
            "Dinginkan dan simpan dalam toples."
        ),
        type = FoodType.MAKANAN,
        servingSize = "±50 buah"
    ),
    FoodItem(
        title = "Sosis Solo",
        description = "Snack khas Solo berbentuk seperti risoles, berisi tumisan ayam manis gurih",
        imageResId = R.drawable.sosis_solo,
        cookTime = "60 Mins",
        ingredients = listOf(
            "Kulit dadar tipis" to "10 lembar",
            "Ayam suwir tumis kecap" to "secukupnya",
            "Telur kocok untuk celup" to "1 butir",
            "Minyak goreng" to "secukupnya"
        ),
        steps = listOf(
            "Ambil kulit dadar, beri isian ayam, lipat seperti risoles.",
            "Celupkan ke telur lalu goreng hingga kecoklatan.",
            "Bisa disimpan di freezer sebelum digoreng.",
            "Sajikan dengan cabai rawit atau saus."
        ),
        type = FoodType.MAKANAN,
        servingSize = "10 sosis solo"
    )



)
