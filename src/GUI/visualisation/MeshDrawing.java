package GUI.visualisation;


import Data.Mesh;
import Modules.ErrorHandling;

import java.awt.*;

public class MeshDrawing extends Canvas {

    private Mesh mesh;

    public MeshDrawing() { }

    public void setMesh( Mesh mesh ) {
        this.mesh = mesh;
    }

    public void paint( Graphics g ) {

        for( int i=0; i < mesh.getNumberOfColumns(); i++ ) {

            for( int j=0; j < mesh.getNumberOfRows(); j++ ) {

                try {
                    switch( mesh.getCell(i, j).getCondition() ) {

                        case 0:
                            g.setColor(Color.black);

                            break;
                        case 1:
                            g.setColor(Color.blue);
                            break;

                        case 2:
                            g.setColor(Color.red);
                            break;

                        case 3:
                            g.setColor(Color.yellow);
                            break;
                    }

                    g.fillRect( 0 + i * 10 + i, 0 + j * 10  + j, 10, 10 );

                } catch( ErrorHandling e ) {


                }
            }
        }
    }
}
