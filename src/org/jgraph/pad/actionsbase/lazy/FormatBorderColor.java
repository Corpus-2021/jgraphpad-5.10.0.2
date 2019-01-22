/*
 * @(#)FormatBorderColor.java	1.2 31.01.2003
 *
 * Copyright (C) 2001-2004 Gaudenz Alder
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 *
 */
package org.jgraph.pad.actionsbase.lazy;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JColorChooser;

import org.jgraph.graph.AttributeMap;
import org.jgraph.graph.GraphConstants;
import org.jgraph.pad.jgraphpad.GPAction;
import org.microplatform.loaders.Translator;

public class FormatBorderColor extends GPAction {

	/**
	 * @see java.awt.event.ActionListener#actionPerformed(ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		if (getCurrentGraph().getSelectionCount() > 0) {
			Color value =
				JColorChooser.showDialog(
					mdiContainer.getFrame(),
					Translator.getString("ColorDialog"),
					null);
			if (value != null) {
				AttributeMap map = new AttributeMap();
				Object[] keys = new Object[] { GraphConstants.BORDER };
				GraphConstants.setRemoveAttributes(map, keys);
				GraphConstants.setBorderColor(map, value);
				GraphConstants.setOpaque(map, true);
				setSelectionAttributes(map);
			}
		}
	}

}
