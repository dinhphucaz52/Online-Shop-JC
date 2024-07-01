package com.example.onlineshop.utils

import com.example.onlineshop.domain.model.Food
import com.example.onlineshop.utils.AppConstants.BASE_URL

object FakeData {

    val FOOD_LIST = listOf(
        Food(
            "62b72b165e4e6e6e3c6a81e6",
            "A Chảy - Mì Sủi Cảo & Cơm Chiên Gà Xối Mỡ - Shop Online",
            "58/11 Nguyễn Văn Săng, P. Tân Sơn Nhì, Tân Phú, TP. HCM",
            30000,
            "${BASE_URL}assets/images/achay/banner.jpg",
            0,
            listOf(
                "${BASE_URL}assets/images/achay/img1.jpg",
                "${BASE_URL}assets/images/achay/img2.jpg",
                "${BASE_URL}assets/images/achay/img3.jpg"
            )
        ),
        Food(
            "62b72b165e4e6e6e3c6a81e7",
            "Anh Quán - Mì Khô Gà Quay & Hủ Tiếu Mì Sủi Cảo",
            "80/17/138 Dương Quảng Hàm, P. 5, Gò Vấp, TP. HCM",
            40000,
            "${BASE_URL}assets/images/anhquan/banner.jpg",
            0,
            listOf(
                "${BASE_URL}assets/images/anhquan/img1.jpg",
                "${BASE_URL}assets/images/anhquan/img2.jpg",
                "${BASE_URL}assets/images/anhquan/img3.jpg"
            )
        ),
        Food(
            "62b72b165e4e6e6e3c6a81e8",
            "Tiệm NoanNoan SeaFood - Tân Kỳ Tân Quý",
            "295 Tân Kỳ Tân Quý, P. Tân Sơn Nhì, Tân Phú, TP. HCM",
            100000,
            "${BASE_URL}assets/images/bachtuot/banner.jpg",
            0,
            listOf(
                "${BASE_URL}assets/images/bachtuot/img1.jpeg",
                "${BASE_URL}assets/images/bachtuot/img2.jpeg",
                "${BASE_URL}assets/images/bachtuot/img3.jpeg"
            )
        ),
        Food(
            "62b72b165e4e6e6e3c6a81e6",
            "A Chảy - Mì Sủi Cảo & Cơm Chiên Gà Xối Mỡ - Shop Online",
            "58/11 Nguyễn Văn Săng, P. Tân Sơn Nhì, Tân Phú, TP. HCM",
            30000,
            "${BASE_URL}assets/images/achay/banner.jpg",
            0,
            listOf(
                "${BASE_URL}assets/images/achay/img1.jpg",
                "${BASE_URL}assets/images/achay/img2.jpg",
                "${BASE_URL}assets/images/achay/img3.jpg"
            )
        ),
        Food(
            "62b72b165e4e6e6e3c6a81e7",
            "Anh Quán - Mì Khô Gà Quay & Hủ Tiếu Mì Sủi Cảo",
            "80/17/138 Dương Quảng Hàm, P. 5, Gò Vấp, TP. HCM",
            40000,
            "${BASE_URL}assets/images/anhquan/banner.jpg",
            0,
            listOf(
                "${BASE_URL}assets/images/anhquan/img1.jpg",
                "${BASE_URL}assets/images/anhquan/img2.jpg",
                "${BASE_URL}assets/images/anhquan/img3.jpg"
            )
        ),
        Food(
            "62b72b165e4e6e6e3c6a81e8",
            "Tiệm NoanNoan SeaFood - Tân Kỳ Tân Quý",
            "295 Tân Kỳ Tân Quý, P. Tân Sơn Nhì, Tân Phú, TP. HCM",
            100000,
            "${BASE_URL}assets/images/bachtuot/banner.jpg",
            0,
            listOf(
                "${BASE_URL}assets/images/bachtuot/img1.jpeg",
                "${BASE_URL}assets/images/bachtuot/img2.jpeg",
                "${BASE_URL}assets/images/bachtuot/img3.jpeg"
            )
        )
    )

    const val IMG_TEST_URL = "https://serverappsale.onrender.com/assets/images/achay/banner.jpg"

    val LIST_IMG_URL = listOf(
        "https://serverappsale.onrender.com/assets/images/achay/banner.jpg",
        "https://serverappsale.onrender.com/assets/images/achay/banner.jpg",
        "https://serverappsale.onrender.com/assets/images/achay/banner.jpg",
        "https://serverappsale.onrender.com/assets/images/achay/banner.jpg",
        "https://serverappsale.onrender.com/assets/images/achay/banner.jpg",
        "https://serverappsale.onrender.com/assets/images/achay/banner.jpg",
    )

    var SEARCH_HISTORY = mutableListOf(
        "Search history 1",
        "Search history 2",
        "Search history 3",
        "Search history 4",
        "Search history 5",
        "Search history 6",
    )
}