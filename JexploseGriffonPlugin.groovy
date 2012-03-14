/*
 * Copyright 2010-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the 'License');
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an 'AS IS' BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * @author Andres Almiray
 */
class JexploseGriffonPlugin {
    // the plugin version
    String version = '0.3'
    // the version or versions of Griffon the plugin is designed for
    String griffonVersion = '0.9.5 > *'
    // the other plugins this plugin depends on
    Map dependsOn = [swing: '0.9.5']
    // resources that are included in plugin packaging
    List pluginIncludes = []
    // the plugin license
    String license = 'Apache Software License 2.0'
    // Toolkit compatibility. No value means compatible with all
    // Valid values are: swing, javafx, swt, pivot, gtk
    List toolkits = ['swing']
    // Platform compatibility. No value means compatible with all
    // Valid values are:
    // linux, linux64, windows, windows64, macosx, macosx64, solaris
    List platforms = []
    // URL where documentation can be found
    String documentation = ''
    // URL where source can be found
    String source = 'https://github.com/griffon/griffon-jexplose-plugin'

    List authors = [
        [
            name: 'Andres Almiray',
            email: 'aalmiray@yahoo.com'
        ]
    ]
    String title = 'Exposé effect on DesktopPanes'
    String description = '''
Apply an Exposé effect to any JDesktopPane. JExplose was originally developed at [Jayasoft][1] and was later contributed to 
the [jndc-incubator][2] project.

Usage
-----

The following methods become available on View scripts upon installing this plugin

 * **explose(JDesktopPane d)** - triggers the explose animation on a `JDesktopPane`.
 * **explose(Explosable e)** - triggers the explose animation on an `Explosable`.
 * **registerExploseHotKey(target, key)** - register a key listener than will explose the specified target. The target argument
 may be an `Explosable` or a `JDesktopPane`. The key argument may be a `KeyStroke`, a `String` or an `int`.

### Example

The following example registers a hot key (`meta - X`) and a [MouseGesture][3] to trigger the explosion of the desktop

        import org.jdesktop.swingx.jexplose.JExplose
        application(title: 'Griffon + JExplose',
          pack: true,
          locationByPlatform:true,
          iconImage: imageIcon('/griffon-icon-48x48.png').image,
          iconImages: [imageIcon('/griffon-icon-48x48.png').image,
                       imageIcon('/griffon-icon-32x32.png').image,
                       imageIcon('/griffon-icon-16x16.png').image]) {
            desktopPane(id: 'desktop', preferredSize: [430, 330]) {
                (1..10).each { i ->
                    internalFrame(title: "Frame $i",
                                  iconifiable: true, maximizable: true, resizable: true,
                                  size: [150, 150], location: [20*i, 20*i], visible: true) {
                        borderLayout()
                        label "Frame $i", constraints: CENTER
                    }
                }
            }
            registerExploseHotKey(desktop, shortcut('X'))
            JExplose.instance.background = getClass().getResource('/griffon.png')
            mouseGestures(start: true) {
                onProcessGesture { String gesture ->
                    if(gesture == 'R') explose(desktop)
                }
            }
        }

[1]: http://www.jaya.free.fr/jexplose.html
[2]: https://jdnc-incubator.dev.java.net/source/browse/jdnc-incubator/trunk/src/xhanin/
[3]: /plugin/mousegestures
'''
}
