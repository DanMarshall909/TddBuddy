package com.jetbrains.rider.plugins.tddbuddy

import com.intellij.openapi.project.Project

class TestStatusService(private val project: Project) {
    private val uiFeedbackService = UIFeedbackService(project)

    fun onTestStatusChanged(isTestFailed: Boolean) {
        uiFeedbackService.updateFeedback(isTestFailed)
    }
}
