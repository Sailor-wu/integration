package com.dce.console;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


@SuppressWarnings("serial")
public class Console extends JFrame implements ActionListener{

	private JButton save;
	private JButton exit;
	private TrayIcon trayicon;
	private ConsoleHanlder handler;
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source.equals(save)) {
			// 保存
			System.out.println("保存");
		}else if(source.equals(exit)) {
			// 退出  非0 异常退出
			System.exit(0);
		}
	}

	public Console(ConsoleHanlder handler) {
		//initCompoenent();
		if (!SystemTray.isSupported()) {
			return;
		} else {
			this.handler = handler;
			SystemTray systemTray = SystemTray.getSystemTray();
			String company = "";
			Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("img.png"));
			trayicon = new TrayIcon(image, handler.getName(), createMenu());
			trayicon.addActionListener(this);
			try {
				systemTray.add(trayicon);
				trayicon.displayMessage(handler.getName(), company, MessageType.INFO);
			} catch (AWTException e) {
				e.printStackTrace();
			}
		}
	}

	private PopupMenu createMenu() {

		PopupMenu menu = new PopupMenu();
		MenuItem save = new MenuItem("save");
		save.addActionListener(new ActionListener(){//事件
			public void actionPerformed(ActionEvent e) {
				handler.save();
			}
		});
		MenuItem exit = new MenuItem("exit");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				System.exit(0);
			}
		});
		MenuItem open = new MenuItem("open");
		open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				if (!isVisible()) {
					setVisible(true);
					toFront();
				} else {
					toFront();
				}
			}
		});
		menu.add(open);
		menu.addSeparator();
		menu.add(save);
		menu.add(exit);
		return menu;
	
	}
}
