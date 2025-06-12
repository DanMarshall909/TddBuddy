package com.jetbrains.rider.plugins.tddbuddy

import com.intellij.openapi.project.Project
import com.jetbrains.rider.plugins.tddbuddy.model.TestStatusUpdate
import com.jetbrains.rider.plugins.tddbuddy.model.rdTddBuddyModel
import com.jetbrains.rider.projectView.solution
import com.jetbrains.rd.util.lifetime.Lifetime

class TestStatusService(private val project: Project) {
    private val uiFeedbackService = UIFeedbackService(project)

    fun bindToProtocol(lifetime: Lifetime) {
        val model = project.solution.rdTddBuddyModel
        model.testStatusUpdated.advise(lifetime) { update ->
            uiFeedbackService.updateFeedback(update.hasFailedTests, update.firstFailedTestName)
        }
    }
}
