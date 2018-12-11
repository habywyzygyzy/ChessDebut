/*
 * Copyright (C) Bernhard Seybold. All rights reserved.
 *
 * This software is published under the terms of the LGPL Software License,
 * a copy of which has been included with this distribution in the LICENSE.txt
 * file.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 *
 * $Id: PositionViewProperties.java,v 1.1 2003/01/04 16:26:05 BerniMan Exp $
 */

package chesspresso.position.view;

import chesspresso.position.*;
import javax.swing.*;
import java.awt.*;


/**
 *
 * @author  BerniMan
 */
public class PositionViewProperties extends JDialog
{
    
    private static class FontListRenderer extends javax.swing.plaf.basic.BasicComboBoxRenderer
    {
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
        {
            if (value instanceof Font) {
                return super.getListCellRendererComponent(list, ((Font)value).getName(), index, isSelected, cellHasFocus);
            } else {
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        }
    }
    
    //======================================================================
    
    private PositionView m_positionView;
    
    public PositionViewProperties(Frame parent, boolean modal)
    {
        super(parent, modal);
        initComponents();
        
        m_positionView = new PositionView(Position.createInitialPosition());
        m_positionFrame.add(m_positionView, BorderLayout.CENTER);
        
        Font font = m_positionView.getFont();
        teFontSize.setText(Integer.toString(font.getSize()));
        cbSolid.setSelected(m_positionView.getSolidStones());
        
        Font[] allFonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
        for (int i=0; i<allFonts.length; i++) {
            cbFonts.addItem(allFonts[i]);
            cbFonts.setRenderer(new FontListRenderer());
            if (allFonts[i].getName().equals(font.getName())) {
                cbFonts.setSelectedIndex(i);
            }
        }
        
        pack();
    }
    
    private void close()
    {
        setVisible(false);
        dispose();
    }
    
    //======================================================================
    
    private void setFont()
    {
        try {
            Font font = (Font)cbFonts.getSelectedItem();
            if (font != null) {
                int fontSize = Integer.parseInt(teFontSize.getText());
                m_positionView.setFont(font.deriveFont(Font.PLAIN, fontSize));
            }
            m_positionView.setSolidStones(cbSolid.isSelected());
        } catch (NumberFormatException ex) {
            // nothing
        }
    }
    
    public PositionView getPositionView() {return m_positionView;}
    
    //======================================================================
    private void initComponents() {//GEN-BEGIN:initComponents
        jPanel1 = new JPanel();
        jPanel6 = new JPanel();
        jPanel3 = new JPanel();
        butWhiteSquare = new JButton();
        butBlackSquare = new JButton();
        jPanel2 = new JPanel();
        butWhite = new JButton();
        butBlack = new JButton();
        jPanel4 = new JPanel();
        cbFonts = new JComboBox();
        teFontSize = new JTextField();
        cbSolid = new JCheckBox();
        m_positionFrame = new JPanel();

        setTitle("Position View Properties");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel1.setLayout(new BoxLayout(jPanel1, BoxLayout.Y_AXIS));

        jPanel6.setLayout(new BoxLayout(jPanel6, BoxLayout.X_AXIS));

        jPanel3.setBorder(new javax.swing.border.TitledBorder("Square Color"));
        butWhiteSquare.setText("white");
        butWhiteSquare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butWhiteSquareActionPerformed(evt);
            }
        });

        jPanel3.add(butWhiteSquare);

        butBlackSquare.setText("black");
        butBlackSquare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butBlackSquareActionPerformed(evt);
            }
        });

        jPanel3.add(butBlackSquare);

        jPanel6.add(jPanel3);

        jPanel2.setBorder(new javax.swing.border.TitledBorder("Piece Color"));
        butWhite.setText("white");
        butWhite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butWhiteActionPerformed(evt);
            }
        });

        jPanel2.add(butWhite);

        butBlack.setText("black");
        butBlack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butBlackActionPerformed(evt);
            }
        });

        jPanel2.add(butBlack);

        jPanel6.add(jPanel2);

        jPanel1.add(jPanel6);

        jPanel4.setBorder(new javax.swing.border.TitledBorder("Font"));
        jPanel4.setToolTipText("null");
        cbFonts.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbFontsItemStateChanged(evt);
            }
        });

        jPanel4.add(cbFonts);

        teFontSize.setText("12");
        teFontSize.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                teFontSizeKeyTyped(evt);
            }
        });

        jPanel4.add(teFontSize);

        cbSolid.setText("solid");
        cbSolid.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbSolidItemStateChanged(evt);
            }
        });

        jPanel4.add(cbSolid);

        jPanel1.add(jPanel4);

        getContentPane().add(jPanel1, BorderLayout.NORTH);

        m_positionFrame.setLayout(new BorderLayout());

        getContentPane().add(m_positionFrame, BorderLayout.CENTER);

    }//GEN-END:initComponents

    private void cbSolidItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbSolidItemStateChanged
        setFont();
    }//GEN-LAST:event_cbSolidItemStateChanged

    private void teFontSizeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_teFontSizeKeyTyped
        setFont();
    }//GEN-LAST:event_teFontSizeKeyTyped

    private void cbFontsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbFontsItemStateChanged
        setFont();
    }//GEN-LAST:event_cbFontsItemStateChanged

    private void butBlackSquareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butBlackSquareActionPerformed
        JColorChooser colorChooser = new JColorChooser(m_positionView.getBlackSquareColor());
        JDialog dialog = JColorChooser.createDialog(this, "Black Square Color", true, colorChooser, null, null);
        dialog.setVisible(true);
        m_positionView.setBlackSquareColor(colorChooser.getColor());
    }//GEN-LAST:event_butBlackSquareActionPerformed

    private void butWhiteSquareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butWhiteSquareActionPerformed
        JColorChooser colorChooser = new JColorChooser(m_positionView.getWhiteSquareColor());
        JDialog dialog = JColorChooser.createDialog(this, "White Square Color", true, colorChooser, null, null);
        dialog.setVisible(true);
        m_positionView.setWhiteSquareColor(colorChooser.getColor());
    }//GEN-LAST:event_butWhiteSquareActionPerformed

    private void butBlackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butBlackActionPerformed
        JColorChooser colorChooser = new JColorChooser(m_positionView.getBlackColor());
        JDialog dialog = JColorChooser.createDialog(this, "Black Color", true, colorChooser, null, null);
        dialog.setVisible(true);
        m_positionView.setBlackColor(colorChooser.getColor());
    }//GEN-LAST:event_butBlackActionPerformed

    private void butWhiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butWhiteActionPerformed
        JColorChooser colorChooser = new JColorChooser(m_positionView.getWhiteColor());
        JDialog dialog = JColorChooser.createDialog(this, "White Color", true, colorChooser, null, null);
        dialog.setVisible(true);
        m_positionView.setWhiteColor(colorChooser.getColor());
    }//GEN-LAST:event_butWhiteActionPerformed
    
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        close();
    }//GEN-LAST:event_closeDialog
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JPanel jPanel4;
    private JPanel jPanel3;
    private JButton butBlackSquare;
    private JButton butBlack;
    private JButton butWhite;
    private JPanel jPanel2;
    private JButton butWhiteSquare;
    private JComboBox cbFonts;
    private JPanel m_positionFrame;
    private JPanel jPanel1;
    private JPanel jPanel6;
    private JCheckBox cbSolid;
    private JTextField teFontSize;
    // End of variables declaration//GEN-END:variables
    
}
