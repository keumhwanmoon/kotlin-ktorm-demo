package com.demo.ktorm.code.controller

import com.demo.ktorm.code.models.CodeReq
import com.demo.ktorm.code.models.CodeRes
import com.demo.ktorm.code.service.CodeService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/codes")
class CodeController(
    private val codeService: CodeService
) {
    @GetMapping
    fun getCodes(): List<CodeRes> {
        return codeService.getAllCodes()
    }

    @GetMapping("/{codeId}")
    fun getCode(@PathVariable codeId: String): CodeRes {
        return codeService.getCode(codeId)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCode(@RequestBody request: CodeReq): CodeRes {
        return codeService.createCode(request)
    }

    @PutMapping("/{codeId}")
    fun updateCode(
        @PathVariable codeId: String,
        @RequestBody request: CodeReq
    ): CodeRes {
        return codeService.updateCode(codeId, request)
    }

    @DeleteMapping("/{codeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCode(@PathVariable codeId: String) {
        codeService.deleteCode(codeId)
    }
}
