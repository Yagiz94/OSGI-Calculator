package uiservice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import javax.swing.JFrame;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import converter.service.Converter;

public class Activator implements BundleActivator {

	private static BundleContext context;

	// Variables declaration
	private javax.swing.JFrame frame;
	private javax.swing.JButton addBtn;
	private javax.swing.JButton substractBtn;
	private javax.swing.JButton multiplyBtn;
	private javax.swing.JButton divideBtn;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	private Converter service;

	// End of variables declaration

	public Locale getLocale() {
		Locale locale = Locale.getDefault();
		return locale;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		System.out.println("UIService Starting...");

		// Get the context of Converter interface class.
		// service object can reach Converter service ingredients.
		ServiceReference<?> serviceReference = context.getServiceReference(Converter.class);
		service = (Converter) context.getService(serviceReference);
		frame = new JFrame();
		frame.setVisible(true);

		// Check system locale language
		// Locale.setDefault(new Locale("EN", "en"));
		Locale locale = getLocale();
		System.out.println("Locale language " + locale.getLanguage());
		if (locale.getLanguage().equals("en")) {
			initComponentsENG();
		} else {
			initComponentsTR();
		}
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		System.out.println("UIService Stopped");
	}

	public Converter getService() {
		return this.service;
	}

	// This method provides User Interface in English language.
	// service object is used to reach the converter service.
	private void initComponentsENG() {

		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		jTextField2 = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		jTextField3 = new javax.swing.JTextField();
		jPanel2 = new javax.swing.JPanel();
		addBtn = new javax.swing.JButton();
		substractBtn = new javax.swing.JButton();
		multiplyBtn = new javax.swing.JButton();
		divideBtn = new javax.swing.JButton();

		frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		frame.setMaximumSize(new java.awt.Dimension(800, 600));
		frame.setPreferredSize(new java.awt.Dimension(600, 300));

		jPanel1.setLayout(new java.awt.GridLayout(3, 2, 0, 20));

		jLabel1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
		jLabel1.setText("First Number:");
		jPanel1.add(jLabel1);

		jTextField1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
		jPanel1.add(jTextField1);

		jLabel2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
		jLabel2.setText("Second Number:");
		jPanel1.add(jLabel2);

		jTextField2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
		jPanel1.add(jTextField2);

		jLabel3.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
		jLabel3.setLabelFor(jTextField3);
		jLabel3.setText("Result Number:");
		jPanel1.add(jLabel3);

		jTextField3.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
		jPanel1.add(jTextField3);

		addBtn.setText("Add");
		jPanel2.add(addBtn);

		substractBtn.setText("Substract");
		jPanel2.add(substractBtn);

		multiplyBtn.setText("Multiply");
		jPanel2.add(multiplyBtn);

		divideBtn.setText("Divide");
		jPanel2.add(divideBtn);

		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// statusLabel.setText("Add Button clicked.");

				int no1 = service.textToIntENG(jTextField1.getText());
				int no2 = service.textToIntENG(jTextField2.getText());
				int res;

				if (jTextField1.getText().equals("zero") && jTextField2.getText().equals("zero")) {
					res = 0;
					jTextField3.setText("zero");
				} else if (jTextField1.getText().equals("zero")) {
					res = add(0, no2);
					jTextField3.setText(service.numberToTextENG(res));
				} else if (jTextField2.getText().equals("zero")) {
					res = add(no1, 0);
					jTextField3.setText(service.numberToTextENG(res));
				} else {
					res = add(no1, no2);
					jTextField3.setText(service.numberToTextENG(res));
				}

			}
		});
		substractBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// statusLabel.setText("Substract Button clicked.");

				int no1 = service.textToIntENG(jTextField1.getText());
				int no2 = service.textToIntENG(jTextField2.getText());
				int res;
				if (jTextField1.getText().equals("zero") && jTextField2.getText().equals("zero")) {
					res = 0;
					jTextField3.setText("zero");
				} else if (jTextField1.getText().equals("zero")) {
					res = substract(0, no2);
					jTextField3.setText(service.numberToTextENG(res));
				} else if (jTextField2.getText().equals("zero")) {
					res = substract(no1, 0);
					jTextField3.setText(service.numberToTextENG(res));
				} else if (no1 == no2) {
					jTextField3.setText("zero");
				} else {
					res = substract(no1, no2);
					jTextField3.setText(service.numberToTextENG(res));
				}
			}
		});
		multiplyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// statusLabel.setText("Multiply Button clicked.");

				int no1 = service.textToIntENG(jTextField1.getText());
				int no2 = service.textToIntENG(jTextField2.getText());

				// If one of the numbers is zero the answer is zero.
				if (jTextField1.getText().equals("zero") || jTextField2.getText().equals("zero")) {
					jTextField3.setText("zero");
				} else {
					int res = multiply(no1, no2);
					jTextField3.setText(service.numberToTextENG(res));
				}
			}
		});
		divideBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// statusLabel.setText("Divide Button clicked.");

				int no1 = service.textToIntENG(jTextField1.getText());
				int no2 = service.textToIntENG(jTextField2.getText());
				int res = 0;

				// Special cases like zero division are added in this section
				if (jTextField1.getText().equals("zero")) {
					if (jTextField2.getText().equals("zero")) {
						jTextField3.setText("undefined");
					} else {
						jTextField3.setText("zero");
					}
				} else if (jTextField2.getText().equals("zero")) {
					jTextField3.setText("undefined");
				} else {
					res = divide(no1, no2);
					if (res == 0) {
						jTextField3.setText("zero");
					} else {
						jTextField3.setText(service.numberToTextENG(res));
					}
				}
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
		frame.getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(1, 1, 1)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE))));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(56, 56, 56).addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 40, Short.MAX_VALUE)));

		frame.pack();
	}

	// This method provides User Interface in Turkish language.
	// service object is used to reach the converter service.
	private void initComponentsTR() {
		Locale.setDefault(new Locale("TR", "tr")); // For special Turkish character recognition
		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		jTextField2 = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		jTextField3 = new javax.swing.JTextField();
		jPanel2 = new javax.swing.JPanel();
		addBtn = new javax.swing.JButton();
		substractBtn = new javax.swing.JButton();
		multiplyBtn = new javax.swing.JButton();
		divideBtn = new javax.swing.JButton();

		frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		frame.setMaximumSize(new java.awt.Dimension(800, 600));
		frame.setPreferredSize(new java.awt.Dimension(600, 300));

		jPanel1.setLayout(new java.awt.GridLayout(3, 2, 0, 20));

		jLabel1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
		jLabel1.setText("Birinci Sayı:");
		jPanel1.add(jLabel1);

		jTextField1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
		jPanel1.add(jTextField1);

		jLabel2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
		jLabel2.setText("Ikinci Sayı:");
		jPanel1.add(jLabel2);

		jTextField2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
		jPanel1.add(jTextField2);

		jLabel3.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
		jLabel3.setLabelFor(jTextField3);
		jLabel3.setText("Sonuç:");
		jPanel1.add(jLabel3);

		jTextField3.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
		jPanel1.add(jTextField3);

		addBtn.setText("Topla");
		jPanel2.add(addBtn);

		substractBtn.setText("Çıkar");
		jPanel2.add(substractBtn);

		multiplyBtn.setText("Çarp");
		jPanel2.add(multiplyBtn);

		divideBtn.setText("Böl");
		jPanel2.add(divideBtn);

		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int no1 = service.textToIntTR(jTextField1.getText());
				int no2 = service.textToIntTR(jTextField2.getText());
				int res;

				// Special cases like zero addition are added in this section
				if (jTextField1.getText().equals("sıfır") && jTextField2.getText().equals("sýfýr")) {
					res = 0;
					jTextField3.setText("sıfır");
				} else if (jTextField1.getText().equals("sıfır")) {
					res = add(0, no2);
					jTextField3.setText(service.numberToTextTR(res));
				} else if (jTextField2.getText().equals("sıfır")) {
					res = add(no1, 0);
					jTextField3.setText(service.numberToTextTR(res));
				} else {
					res = add(no1, no2);
					jTextField3.setText(service.numberToTextTR(res));
				}
			}
		});
		substractBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int no1 = service.textToIntTR(jTextField1.getText());
				int no2 = service.textToIntTR(jTextField2.getText());
				int res;

				// Special cases like zero substraction are added in this section
				if (jTextField1.getText().equals("sıfır") && jTextField2.getText().equals("sıfır")) {
					res = 0;
					jTextField3.setText("sıfır");
				} else if (jTextField1.getText().equals("sıfır")) {
					res = substract(0, no2);
					jTextField3.setText(service.numberToTextTR(res));
				} else if (jTextField2.getText().equals("sıfır")) {
					res = substract(no1, 0);
					jTextField3.setText(service.numberToTextTR(res));
				} else if (no1 == no2) {
					jTextField3.setText("sıfır");
				} else {
					res = substract(no1, no2);
					jTextField3.setText(service.numberToTextTR(res));
				}
			}
		});
		multiplyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int no1 = service.textToIntTR(jTextField1.getText());
				int no2 = service.textToIntTR(jTextField2.getText());

				// Special cases like zero multiplication are added in this section
				if (jTextField1.getText().equals("sıfır") || jTextField2.getText().equals("sıfır")) {
					jTextField3.setText("sıfır");
				} else {
					int res = multiply(no1, no2);
					jTextField3.setText(service.numberToTextTR(res));
				}
			}
		});
		divideBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int no1 = service.textToIntTR(jTextField1.getText());
				int no2 = service.textToIntTR(jTextField2.getText());
				int res = 0;

				// Special cases like zero division are added in this section
				if (jTextField1.getText().equals("sıfır")) {
					if (jTextField2.getText().equals("sıfır")) {
						jTextField3.setText("tanımsız");
					} else {
						jTextField3.setText("sıfır");
					}
				} else if (jTextField2.getText().equals("sıfır")) {
					jTextField3.setText("tanımsız");
				} else {
					res = divide(no1, no2);
					if (res == 0) {
						jTextField3.setText("sıfır");
					} else {
						jTextField3.setText(service.numberToTextTR(res));
					}
				}
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
		frame.getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(1, 1, 1)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE))));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(56, 56, 56).addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 40, Short.MAX_VALUE)));

		frame.pack();
	}// </editor-fold>

	public int add(int a, int b) {
		return a + b;
	}

	public int multiply(int a, int b) {
		return a * b;
	}

	public int substract(int a, int b) {
		return a - b;
	}

	public int divide(int a, int b) {

		int result;
		if (a < b) {
			result = 0;
		} else {
			result = a / b;
		}
		return result;
	}
}
