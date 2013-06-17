
Exposé effect on DesktopPanes
------------------------------

Plugin page: [http://artifacts.griffon-framework.org/plugin/jexplose](http://artifacts.griffon-framework.org/plugin/jexplose)


Apply an Expose effect to any JDesktopPane. JExplose was originally developed at [Jayasoft][1] and was later contributed to 
the [jndc-incubator][2] project.

Usage
-----

The following methods become available on View scripts upon installing this plugin

 * **explose(JDesktopPane d)** - triggers the explose animation on a `JDesktopPane`.
 * **explose(Explosable e)** - triggers the explose animation on an `Explosable`.
 * **registerExploseHotKey(target, key)** - register a key listener than will explose the specified target. The target argument
 may be an `Explosable` or a `JDesktopPane`. The key argument may be a `KeyStroke`, a `String` or an `int`.

### Example

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

