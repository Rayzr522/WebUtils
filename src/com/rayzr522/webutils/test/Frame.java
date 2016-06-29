
package com.rayzr522.webutils.test;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import com.rayzr522.webutils.net.HTTPRequest;
import com.rayzr522.webutils.utils.FilesUtils;

public class Frame {

	private JFrame		frmFileDownloader;
	private JTextField	txtFileToDownload;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					Frame window = new Frame();
					window.frmFileDownloader.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame() {
		initialize();
	}

	private void download() {

		String url = txtFileToDownload.getText().replaceAll(" ", "%20");

		if (url == null || url.isEmpty()) { return; }

		HTTPRequest req = HTTPRequest.get(url);

		if (!req.isValid()) {
			System.err.println("Request is not valid");
			return;
		}

		System.out.println("req.getFileName() = " + req.getFileName());

		String extension = FilesUtils.getExtension(req.getFileName());

		List<String> useableExtensions = Arrays.asList("jar", "zip", "java", "txt", "js");

		if (useableExtensions.contains(extension)) {

			// Downloader.downloadFile(req, new File(System.getPropr))

		}

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFileDownloader = new JFrame();
		frmFileDownloader.getContentPane().setBackground(Color.DARK_GRAY);
		frmFileDownloader.setBackground(Color.GRAY);
		frmFileDownloader.setIconImage(Toolkit.getDefaultToolkit().getImage(Frame.class.getResource("/icons/File_Icon.png")));
		frmFileDownloader.setTitle("File Downloader");
		frmFileDownloader.setBounds(100, 100, 640, 480);
		frmFileDownloader.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frmFileDownloader.getContentPane().setLayout(springLayout);

		JLabel lblFileDownloader = new JLabel("File Downloader");
		lblFileDownloader.setForeground(Color.WHITE);
		lblFileDownloader.setBackground(Color.GRAY);
		springLayout.putConstraint(SpringLayout.NORTH, lblFileDownloader, 10, SpringLayout.NORTH, frmFileDownloader.getContentPane());
		lblFileDownloader.setLabelFor(frmFileDownloader);
		lblFileDownloader.setIcon(new ImageIcon(Frame.class.getResource("/icons/File_Icon.png")));
		springLayout.putConstraint(SpringLayout.WEST, lblFileDownloader, 0, SpringLayout.WEST, frmFileDownloader.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblFileDownloader, 0, SpringLayout.EAST, frmFileDownloader.getContentPane());
		lblFileDownloader.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblFileDownloader.setHorizontalAlignment(SwingConstants.CENTER);
		frmFileDownloader.getContentPane().add(lblFileDownloader);

		txtFileToDownload = new JTextField();
		springLayout.putConstraint(SpringLayout.SOUTH, lblFileDownloader, -6, SpringLayout.NORTH, txtFileToDownload);
		springLayout.putConstraint(SpringLayout.NORTH, txtFileToDownload, 238, SpringLayout.NORTH, frmFileDownloader.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, txtFileToDownload, 0, SpringLayout.WEST, frmFileDownloader.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtFileToDownload, 0, SpringLayout.EAST, frmFileDownloader.getContentPane());
		txtFileToDownload.setFont(new Font("Monospaced", Font.PLAIN, 12));
		txtFileToDownload.setText("File to download");
		frmFileDownloader.getContentPane().add(txtFileToDownload);
		txtFileToDownload.setColumns(10);

		JButton btnDownload = new JButton("Download");
		btnDownload.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				download();
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, txtFileToDownload, -6, SpringLayout.NORTH, btnDownload);
		btnDownload.setSelectedIcon(new ImageIcon(Frame.class.getResource("/icons/File_Icon.png")));
		springLayout.putConstraint(SpringLayout.WEST, btnDownload, 0, SpringLayout.WEST, frmFileDownloader.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnDownload, 0, SpringLayout.EAST, frmFileDownloader.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnDownload, 0, SpringLayout.SOUTH, frmFileDownloader.getContentPane());
		frmFileDownloader.getContentPane().add(btnDownload);
	}

}
