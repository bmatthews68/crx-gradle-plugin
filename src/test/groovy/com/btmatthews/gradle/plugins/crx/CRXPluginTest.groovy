package com.btmatthews.gradle.plugins.crx

import org.junit.Test
import org.gradle.testfixtures.ProjectBuilder
import org.gradle.api.Project
import com.btmatthews.gradle.plugins.crx.tasks.CRXTask

import static org.junit.Assert.assertTrue

/**
 * @author <a href="mailto:brian@btmatthews.com">Brian Matthews</a>
 */
class CRXPluginTest {
    @Test
    public void crxPluginAddsCRXTaskToProject() {
        Project project = ProjectBuilder.builder().build()
        project.apply plugin: 'crx'

        assertTrue(project.tasks.crx instanceof CRXTask)
    }
}
