/*
 * Created by JFormDesigner on Sat May 24 10:57:01 CEST 2014
 */

package GUI.openFile;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class OpenFile extends JFileChooser {

    public OpenFile() {

        initComponents();

        FileNameExtensionFilter filtr = new FileNameExtensionFilter( "Pliki typu .siatka", "siatka" );
        this.setFileFilter( filtr );
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Dariusz Dybka
        setDialogTitle("Otw\u00f3rz plik");
        //---- this ----
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Dariusz Dybka
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
