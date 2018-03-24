/**
* PFDSubcomponent.java
* 
* Superclass for all elements of the HSI which are subcomponents of
* HSIComponent.
* 
* Copyright (C) 2007  Georg Gruetter (gruetter@gmail.com)
* 
* This program is free software; you can redistribute it and/or
* modify it under the terms of the GNU General Public License
* as published by the Free Software Foundation; either version 2 
* of the License, or (at your option) any later version.
*
* This library is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
* 
* You should have received a copy of the GNU Lesser General Public
* License along with this library; if not, write to the Free Software
* Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
*/
package net.sourceforge.xhsi.flightdeck.pfd;


import java.awt.Component;
import java.awt.Graphics2D;

import net.sourceforge.xhsi.XHSIPreferences;
import net.sourceforge.xhsi.model.ModelFactory;
import net.sourceforge.xhsi.flightdeck.Subcomponent;



public abstract class PFDSubcomponent extends Subcomponent {

	private static final long serialVersionUID = 1L;
	
	PFDGraphicsConfig pfd_gc;


    public PFDSubcomponent(ModelFactory model_factory, PFDGraphicsConfig pfd_gc) {
        super(model_factory, pfd_gc);

        this.pfd_gc = pfd_gc;

        this.model_factory = model_factory;
        this.aircraft = this.model_factory.get_aircraft_instance();
        this.avionics = this.aircraft.get_avionics();
        this.aircraft_environment = this.aircraft.get_environment();
        this.fms = this.avionics.get_fms();
        this.tcas = this.avionics.get_tcas();
        this.preferences = XHSIPreferences.get_instance();

        this.parent_component = null;

    }


    public PFDSubcomponent(ModelFactory model_factory, PFDGraphicsConfig pfd_gc, Component parent_component) {
        this(model_factory, pfd_gc);
        this.parent_component = parent_component;
    }


    public abstract void paint(Graphics2D g2);


//    protected BufferedImage create_buffered_image(int width, int height) {
//
//        GraphicsConfiguration gc = this.parent_component.getGraphicsConfiguration();
//        BufferedImage buf_img = gc.createCompatibleImage(width, height, Transparency.BITMASK);
//        return buf_img;
//
//    }


//    protected Graphics2D get_graphics(BufferedImage buf_img) {
//
//        Graphics2D gImg = (Graphics2D)buf_img.getGraphics();
//        gImg.setComposite(AlphaComposite.Src);
//        gImg.setColor(Color.BLACK);
//        gImg.fillRect(0, 0, buf_img.getWidth(), buf_img.getHeight());
//        gImg.setRenderingHints(pfd_gc.rendering_hints);
//        gImg.setStroke(new BasicStroke(2.0f));
//        return gImg;
//
//    }


}
