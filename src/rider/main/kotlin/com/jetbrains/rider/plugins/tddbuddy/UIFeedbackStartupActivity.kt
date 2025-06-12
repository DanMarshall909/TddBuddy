package com.jetbrains.rider.plugins.tddbuddy

import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.StartupActivity

class UIFeedbackStartupActivity : StartupActivity {
    override fun runActivity(project: Project) {
        // Show red border on startup for demo/testing
        UIFeedbackService(project).updateFeedback(true)
    }
}
