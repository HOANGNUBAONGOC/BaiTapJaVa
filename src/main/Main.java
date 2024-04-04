package main;

import java.awt.EventQueue;

import view.TheMuonView;

public class Main {
	 public static void main(String[] args) {
	        EventQueue.invokeLater(() -> {
	            try {
	                TheMuonView frame = new TheMuonView();
	                frame.setVisible(true);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        });
	    }
}
