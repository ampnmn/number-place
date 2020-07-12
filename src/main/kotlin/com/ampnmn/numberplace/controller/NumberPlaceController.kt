package com.ampnmn.numberplace.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("number-place")
class NumberPlaceController {
    @GetMapping
    fun getIndex(): String {
        return "index"
    }
}
