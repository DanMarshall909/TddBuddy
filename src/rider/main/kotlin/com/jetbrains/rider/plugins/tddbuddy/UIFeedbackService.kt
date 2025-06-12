package com.jetbrains.rider.plugins.tddbuddy

import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.WindowManager
import java.awt.Color
import javax.swing.BorderFactory
import javax.swing.SwingUtilities

class UIFeedbackService(private val project: Project) {
    fun updateFeedback(isTestFailed: Boolean) {
        SwingUtilities.invokeLater {
            val frame = WindowManager.getInstance().getFrame(project)
            if (frame != null) {
                if (isTestFailed) {
                    frame.rootPane.border = BorderFactory.createLineBorder(Color.RED, 5)
                    showFeedback("Test Failed!")
                } else {
                    frame.rootPane.border = BorderFactory.createEmptyBorder()
                    showFeedback("All Tests Passed!")
                }
                frame.repaint()
            }
        }
    }

    private fun showFeedback(message: String) {
        val statusBar = WindowManager.getInstance().getStatusBar(project)
        statusBar?.info = message
    }
}
