/**
 * @file .java
 * @author Anderson Antunes <anderson.utf@gmail.com>
 *         *seu nome* <*seu email*>
 * @version 1.0
 *
 * @section LICENSE
 *
 * Copyright (C) 2013 by Anderson Antunes <anderson.utf@gmail.com>
 *                       *seu nome* <*seu email*>
 *
 * RobotInterface is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 *
 * RobotInterface is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * RobotInterface. If not, see <http://www.gnu.org/licenses/>.
 *
 */
package s3f.jifi.flowchart.blocks;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import s3f.jifi.flowchart.Command;
import static s3f.jifi.flowchart.Command.identChar;
import s3f.jifi.flowchart.GraphicFlowchart;
import static s3f.jifi.flowchart.GraphicFlowchart.GF_J;
import static s3f.jifi.flowchart.blocks.DummyBlock.SHAPE_CIRCLE;
import static s3f.jifi.flowchart.blocks.DummyBlock.createSimpleBlock;
import s3f.jifi.flowchart.blocks.ScriptBlock.FunctionEnd;
import s3f.magenta.GraphicObject;
import s3f.magenta.graphicresource.GraphicResource;
import s3f.magenta.sidepanel.Item;
import s3f.magenta.swing.MutableWidgetContainer;

/**
 * Laço de repetição simples.
 */
public class DoWhile extends Block {

    private static Color myColor = Color.decode("#1281BD");
    private GraphicObject resource = null;

    public DoWhile() {
        MutableWidgetContainer mwc = If.createSimpleIf(this, "0");
        mwc.setName("While");
        mwc.setColor(myColor);
        getEnd().setRes((GraphicObject) mwc);
    }

    public DoWhile(String procedure) {
        this();
        setProcedure(procedure);
    }

    @Override
    public void toString(String ident, StringBuilder sb) {
        sb.append(ident).append("do {\n");
        Command it = start;
        while (it != null) {
            it.toString(ident + identChar, sb);
            it = it.getNext();
        }
        sb.append(ident).append("}").append(" while (").append(getProcedure()).append(");\n");
    }

    @Override
    public Item getItem() {
//        Area myShape = new Area();
//        Polygon tmpPoli = new Polygon();
//        tmpPoli.addPoint(10, 2);
//        tmpPoli.addPoint(18, 10);
//        tmpPoli.addPoint(10, 18);
//        tmpPoli.addPoint(2, 10);
//        myShape.add(new Area(tmpPoli));
//        Shape tmpShape = new Ellipse2D.Double(0, 0, 20, 20);
//        myShape.exclusiveOr(new Area(tmpShape));
        Area myShape = new Area();
        Polygon tmpPoli = new Polygon();
        tmpPoli.addPoint(10, 0);
        tmpPoli.addPoint(20, 10);
        tmpPoli.addPoint(10, 20);
        tmpPoli.addPoint(0, 10);
        myShape.add(new Area(tmpPoli));
        myShape.subtract(new Area(new Ellipse2D.Double(5, 5, 10, 10)));
        myShape.add(new Area(new Ellipse2D.Double(7, 7, 6, 6)));
        return new Item("dRepetição", myShape, myColor, "Repete os comandos internos enquando a condição fornecida for verdadeira");
    }

    @Override
    public Object createInstance() {
        return new DoWhile();
    }

    @Override
    public GraphicObject getDrawableResource() {
        if (resource == null) {
            resource = createSimpleBlock(this, " do ", Color.BLACK, myColor, SHAPE_CIRCLE);;
        }
        return resource;
    }

    @Override
    public void drawLines(Graphics2D g) {
        if (resource != null) {
            Path2D.Double path = new Path2D.Double();
            Rectangle2D.Double bThis = resource.getObjectBouds();
            Rectangle2D.Double bBlock = start.getBounds(null, GraphicFlowchart.GF_J, GraphicFlowchart.GF_K);
            path.moveTo(bThis.getCenterX(), bThis.getMaxY());
            path.lineTo(bThis.getCenterX(), bThis.getMaxY() + GF_J);

            Command c = start;

            Rectangle2D.Double bEnd = c.getBounds(null,
                    GraphicFlowchart.GF_J,
                    GraphicFlowchart.GF_K);

            //obtem o ultimo comando e calcula a largura real do bloco
            while (c.getNext() != null && !(c.getNext() instanceof BlockEnd)) {
                c = c.getNext();
                //calcula o tamanho real (não estimado) do bloco
                bBlock.add(c.getBounds(null, GraphicFlowchart.GF_J, GraphicFlowchart.GF_K));
            }
            bBlock.add(c.getBounds(null, GraphicFlowchart.GF_J, GraphicFlowchart.GF_K));

            //adicionando bordas
            bBlock.x -= GF_K;
            bBlock.width += 2 * GF_K;
            bBlock.height += 2 * GF_J;

            if (c instanceof GraphicResource) {
                GraphicObject d = ((GraphicResource) c).getDrawableResource();
                if (d != null) {
                    bEnd = d.getObjectBouds();
                }
            }

            Rectangle2D.Double bE = getEnd().getDrawableResource().getObjectBouds();

            path.moveTo(bEnd.getCenterX(), bE.getCenterY());
            path.lineTo(bEnd.getCenterX(), bE.getCenterY());
            path.lineTo(bBlock.getMinX(), bE.getCenterY());
            path.lineTo(bBlock.getMinX(), bThis.getCenterY());
            path.lineTo(bThis.getCenterX(), bThis.getCenterY());

            c = getNext();
            boolean end = false;
//
            if (c != null && c instanceof BlockEnd && !(c instanceof FunctionEnd)) {
                end = true;
                c = this.getParent();
                if (c != null && !(c instanceof DoWhile)) {
                    c = c.getParent();
                    if (c != null && !(c instanceof If)) {
                        c = null;
                    }
                }
            }

            Rectangle2D.Double bNext = null;
            if (c instanceof GraphicResource) {
                GraphicObject d = ((GraphicResource) c).getDrawableResource();
                if (d != null) {

//                    g.drawString("F", (int) bThis.getMaxX() + 5, (int) bThis.getCenterY() - 5);
//                    g.drawString("T", (int) bThis.getCenterX() - 20, (int) bThis.getMaxY() + 10);
//
                    path.moveTo(bThis.getCenterX(), bE.getCenterY());
//                    path.lineTo(bBlock.getMaxX(), bThis.getCenterY());
//                    path.lineTo(bBlock.getMaxX(), bBlock.getMaxY() - GF_J);
                    if (!end) {
                        bNext = d.getObjectBouds();
//                        path.lineTo(bNext.getCenterX(), bE.getMaxY() - GF_J);
                        path.lineTo(bNext.getCenterX(), bNext.getMinY());
                    } else {
//                        path.lineTo(bThis.getCenterX(), bBlock.getMaxY() - GF_J);
//                        path.lineTo(bThis.getCenterX(), bBlock.getMaxY());
                    }
                }
            }
            g.draw(path);
            drawArrow(g, bThis.getMinX() + 1, bThis.getCenterY(), ARROW_RIGHT);
            drawArrow(g, bThis.getCenterX(), bBlock.getMinY(), ARROW_DOWN);
            if (bNext != null) {
                drawArrow(g, bNext.getCenterX(), bNext.getMinY(), ARROW_DOWN);
            }
        }
    }

    @Override
    public Rectangle2D.Double getBounds(Rectangle2D.Double tmp, double j, double k) {
        Rectangle2D.Double bounds = super.getBounds(tmp, j, k);
        bounds.width += k;
        bounds.x -= k / 2;
//        bounds.height += 2 * j;
        return bounds;
    }
}
