package com.btmatthews.gradle.plugins.crx

/**
 * @author <a href="mailto:brian@btmatthews.com">Brian Matthews</a>
 */
class CRXPluginExtension {
    def String pemFile
    def String pemPassword;
    def String crxSourceDirectory = "src/main/chrome";
    def String packagingIncludes;
    def String packagingExcludes;
}
