package com.saragarcia6123.mini_commit

import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import javax.swing.BoxLayout
import javax.swing.JButton
import javax.swing.JLabel
import javax.swing.JPanel

class MiniCommitToolWindowFactory : ToolWindowFactory {
    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {

        val mainPanel = JPanel()
        mainPanel.layout = BoxLayout(mainPanel, BoxLayout.Y_AXIS)

        val contentPanel = JPanel()

        val reloadButton = JButton("Reload").apply {
            addActionListener {
                updateContent(contentPanel, "Refresh test for debug purposes")
            }
        }

        mainPanel.add(contentPanel)
        mainPanel.add(reloadButton)

        updateContent(contentPanel, "Hello World!")
        toolWindow.component.add(mainPanel)
    }

    private fun updateContent(panel: JPanel, text: String) {
        panel.removeAll()
        panel.add(JLabel(text))
        panel.revalidate()
        panel.repaint()
    }
}
