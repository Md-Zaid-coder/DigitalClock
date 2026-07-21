//import javax.swing.JFrame;      
//import javax.swing.JPanel;    
//import javax.swing.JLabel;
//import javax.swing.JButton;
//import javax.swing.JTextField;
//import javax.swing.Timer;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.awt.Color;
//import java.awt.BorderLayout;
//import java.awt.FlowLayout;
//import java.awt.GridLayout;
//import javax.swing.SwingConstants;
//
//public class DigitalClock {
//
//    // Clock variables
//
//    // Stopwatch variables
//    private static long elapsedMilliseconds = 0;
//    private static boolean stopwatchRunning = false;
//    private static long stopwatchStartTime = 0;
//
//    // Countdown Timer variables
//    private static long countdownMilliseconds = 0;  // Time remaining
//    private static boolean countdownRunning = false;
//    private static long countdownStartTime = 0;
//    private static long countdownTotal = 0;  // Total time set by user
//
//    public static void main(String[] args) {
//        // Create the window
//        JFrame window = new JFrame("Digital Clock & Stopwatch & Countdown Timer");
//        window.setSize(900, 700);
//        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        // Create main panel
//        JPanel mainPanel = new JPanel();
//        mainPanel.setBackground(Color.BLACK);
//        mainPanel.setLayout(new BorderLayout(10, 10));
//
//        // ===== CLOCK SECTION =====
//        JPanel clockPanel = new JPanel();
//        clockPanel.setBackground(Color.BLACK);
//        clockPanel.setLayout(new BorderLayout(0, 10));
//
//        JLabel timeLabel = new JLabel("00:00:00 AM");
//        timeLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 50));
//        timeLabel.setForeground(Color.CYAN);
//        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
//
//        JLabel dateLabel = new JLabel("Monday, January 15, 2025");
//        dateLabel.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 16));
//        dateLabel.setForeground(Color.WHITE);
//        dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
//
//        clockPanel.add(timeLabel, BorderLayout.CENTER);
//        clockPanel.add(dateLabel, BorderLayout.SOUTH);
//
//        // ===== STOPWATCH SECTION =====
//        JPanel stopwatchPanel = new JPanel();
//        stopwatchPanel.setBackground(Color.BLACK);
//        stopwatchPanel.setLayout(new BorderLayout(0, 10));
//
//        JLabel stopwatchLabel = new JLabel("00:00:00");
//        stopwatchLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 50));
//        stopwatchLabel.setForeground(Color.GREEN);
//        stopwatchLabel.setHorizontalAlignment(SwingConstants.CENTER);
//
//        JPanel stopwatchButtonsPanel = new JPanel();
//        stopwatchButtonsPanel.setBackground(Color.BLACK);
//        stopwatchButtonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 5));
//
//        JButton startStopwatchBtn = new JButton("START");
//        startStopwatchBtn.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
//        startStopwatchBtn.setBackground(Color.GREEN);
//        startStopwatchBtn.setForeground(Color.BLACK);
//        startStopwatchBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (!stopwatchRunning) {
//                    stopwatchRunning = true;
//                    stopwatchStartTime = System.currentTimeMillis() - elapsedMilliseconds;
//                }
//            }
//        });
//
//        JButton stopStopwatchBtn = new JButton("STOP");
//        stopStopwatchBtn.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
//        stopStopwatchBtn.setBackground(Color.YELLOW);
//        stopStopwatchBtn.setForeground(Color.BLACK);
//        stopStopwatchBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (stopwatchRunning) {
//                    stopwatchRunning = false;
//                }
//            }
//        });
//
//        JButton resetStopwatchBtn = new JButton("RESET");
//        resetStopwatchBtn.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
//        resetStopwatchBtn.setBackground(Color.RED);
//        resetStopwatchBtn.setForeground(Color.BLACK);
//        resetStopwatchBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                stopwatchRunning = false;
//                elapsedMilliseconds = 0;
//                stopwatchLabel.setText("00:00:00");
//            }
//        });
//
//        stopwatchButtonsPanel.add(startStopwatchBtn);
//        stopwatchButtonsPanel.add(stopStopwatchBtn);
//        stopwatchButtonsPanel.add(resetStopwatchBtn);
//
//        stopwatchPanel.add(stopwatchLabel, BorderLayout.CENTER);
//        stopwatchPanel.add(stopwatchButtonsPanel, BorderLayout.SOUTH);
//
//        // ===== COUNTDOWN TIMER SECTION =====
//        JPanel countdownPanel = new JPanel();
//        countdownPanel.setBackground(Color.BLACK);
//        countdownPanel.setLayout(new BorderLayout(0, 10));
//
//        // Input section for countdown
//        JPanel countdownInputPanel = new JPanel();
//        countdownInputPanel.setBackground(Color.BLACK);
//        countdownInputPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
//
//        JLabel inputLabel = new JLabel("Enter Time: ");
//        inputLabel.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 14));
//        inputLabel.setForeground(Color.WHITE);
//
//        JTextField minutesField = new JTextField("01", 2);
//        minutesField.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 16));
//        minutesField.setHorizontalAlignment(SwingConstants.CENTER);
//
//        JLabel colonLabel = new JLabel(":");
//        colonLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));
//        colonLabel.setForeground(Color.WHITE);
//
//        JTextField secondsField = new JTextField("30", 2);
//        secondsField.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 16));
//        secondsField.setHorizontalAlignment(SwingConstants.CENTER);
//
//        JButton setTimeBtn = new JButton("SET");
//        setTimeBtn.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));
//        setTimeBtn.setBackground(Color.CYAN);
//        setTimeBtn.setForeground(Color.BLACK);
//
//        countdownInputPanel.add(inputLabel);
//        countdownInputPanel.add(minutesField);
//        countdownInputPanel.add(colonLabel);
//        countdownInputPanel.add(secondsField);
//        countdownInputPanel.add(setTimeBtn);
//
//        // Countdown display
//        JLabel countdownLabel = new JLabel("01:30");
//        countdownLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 50));
//        countdownLabel.setForeground(Color.MAGENTA);
//        countdownLabel.setHorizontalAlignment(SwingConstants.CENTER);
//
//        // Countdown buttons
//        JPanel countdownButtonsPanel = new JPanel();
//        countdownButtonsPanel.setBackground(Color.BLACK);
//        countdownButtonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 5));
//
//        JButton startCountdownBtn = new JButton("START");
//        startCountdownBtn.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
//        startCountdownBtn.setBackground(Color.GREEN);
//        startCountdownBtn.setForeground(Color.BLACK);
//        startCountdownBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (!countdownRunning && countdownTotal > 0) {
//                    countdownRunning = true;
//                    countdownStartTime = System.currentTimeMillis();
//                }
//            }
//        });
//
//        JButton stopCountdownBtn = new JButton("STOP");
//        stopCountdownBtn.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
//        stopCountdownBtn.setBackground(Color.YELLOW);
//        stopCountdownBtn.setForeground(Color.BLACK);
//        stopCountdownBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (countdownRunning) {
//                    countdownRunning = false;
//                }
//            }
//        });
//
//        JButton resetCountdownBtn = new JButton("RESET");
//        resetCountdownBtn.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
//        resetCountdownBtn.setBackground(Color.RED);
//        resetCountdownBtn.setForeground(Color.BLACK);
//        resetCountdownBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                countdownRunning = false;
//                countdownMilliseconds = countdownTotal;
//
//                long minutes = (countdownTotal / 1000) / 60;
//                long seconds = (countdownTotal / 1000) % 60;
//                countdownLabel.setText(String.format("%02d:%02d", minutes, seconds));
//            }
//        });
//
//        countdownButtonsPanel.add(startCountdownBtn);
//        countdownButtonsPanel.add(stopCountdownBtn);
//        countdownButtonsPanel.add(resetCountdownBtn);
//
//        // SET button action
//        setTimeBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    int minutes = Integer.parseInt(minutesField.getText());
//                    int seconds = Integer.parseInt(secondsField.getText());
//
//                    // Validate input
//                    if (minutes < 0 || minutes > 59 || seconds < 0 || seconds > 59) {
//                        countdownLabel.setText("INVALID");
//                        return;
//                    }
//
//                    // Convert to milliseconds
//                    countdownTotal = (minutes * 60 + seconds) * 1000;
//                    countdownMilliseconds = countdownTotal;
//                    countdownRunning = false;
//
//                    // Update display
//                    countdownLabel.setText(String.format("%02d:%02d", minutes, seconds));
//                } catch (NumberFormatException ex) {
//                    countdownLabel.setText("ERROR");
//                }
//            }
//        });
//
//        countdownPanel.add(countdownInputPanel, BorderLayout.NORTH);
//        countdownPanel.add(countdownLabel, BorderLayout.CENTER);
//        countdownPanel.add(countdownButtonsPanel, BorderLayout.SOUTH);
//
//        // ===== ADD ALL SECTIONS TO MAIN PANEL =====
//        mainPanel.add(clockPanel, BorderLayout.NORTH);
//
//        JPanel timerPanel = new JPanel();
//        timerPanel.setBackground(Color.BLACK);
//        timerPanel.setLayout(new GridLayout(2, 1, 0, 10));
//        timerPanel.add(stopwatchPanel);
//        timerPanel.add(countdownPanel);
//
//        mainPanel.add(timerPanel, BorderLayout.CENTER);
//
//        window.add(mainPanel);
//
//        // ===== TIMER: Update clock, stopwatch, and countdown =====
//        Timer timer = new Timer(100, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // ===== UPDATE CLOCK =====
//                SimpleDateFormat timeSdf = new SimpleDateFormat("hh:mm:ss a");
//                String currentTime = timeSdf.format(new Date());
//                timeLabel.setText(currentTime);
//
//                SimpleDateFormat dateSdf = new SimpleDateFormat("EEEE, MMMM dd, yyyy");
//                String currentDate = dateSdf.format(new Date());
//                dateLabel.setText(currentDate);
//
//                // ===== UPDATE STOPWATCH =====
//                if (stopwatchRunning) {
//                    elapsedMilliseconds = System.currentTimeMillis() - stopwatchStartTime;
//                }
//
//                long totalSeconds = elapsedMilliseconds / 1000;
//                long hours = totalSeconds / 3600;
//                long minutes = (totalSeconds % 3600) / 60;
//                long seconds = totalSeconds % 60;
//
//                String stopwatchTime = String.format("%02d:%02d:%02d", hours, minutes, seconds);
//                stopwatchLabel.setText(stopwatchTime);
//
//                // ===== UPDATE COUNTDOWN =====
//                if (countdownRunning) {
//                    long elapsedSinceStart = System.currentTimeMillis() - countdownStartTime;
//                    countdownMilliseconds = countdownTotal - elapsedSinceStart;
//
//                    // If countdown reaches zero
//                    if (countdownMilliseconds <= 0) {
//                        countdownMilliseconds = 0;
//                        countdownRunning = false;
//                        countdownLabel.setText("TIME'S UP!");
//                        countdownLabel.setForeground(Color.RED);
//                    }
//                }
//
//                // Update countdown display
//                long countdownSecs = countdownMilliseconds / 1000;
//                long countdownMins = countdownSecs / 60;
//                long countdownRemainingSecs = countdownSecs % 60;
//
//                if (countdownMilliseconds > 0) {
//                    countdownLabel.setText(String.format("%02d:%02d", countdownMins, countdownRemainingSecs));
//                    countdownLabel.setForeground(Color.MAGENTA);  // Normal color
//                }
//            }
//        });
//
//        timer.start();
//        window.setVisible(true);
//    }
//}
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.JLabel;
//import javax.swing.JButton;
//import javax.swing.JTextField;
//import javax.swing.Timer;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.awt.Color;
//import java.awt.BorderLayout;
//import java.awt.FlowLayout;
//import java.awt.GridLayout;
//import javax.swing.SwingConstants;
//
//public class DigitalClock {
//
//    // ===== THEME SETTINGS =====
//    private static boolean isDarkMode = true;  // Theme toggle
//
//    // ===== STOPWATCH VARIABLES =====
//    private static long elapsedMilliseconds = 0;
//    private static boolean stopwatchRunning = false;
//    private static long stopwatchStartTime = 0;
//
//    // ===== COUNTDOWN VARIABLES =====
//    private static long countdownMilliseconds = 0;
//    private static boolean countdownRunning = false;
//    private static long countdownStartTime = 0;
//    private static long countdownTotal = 0;
//
//    // ===== UI COMPONENTS =====
//    private static JLabel timeLabel;
//    private static JLabel dateLabel;
//    private static JLabel stopwatchLabel;
//    private static JLabel countdownLabel;
//    private static JTextField minutesField;
//    private static JTextField secondsField;
//    private static JButton themeToggleBtn;
//
//    // ===== MAIN CONTAINERS =====
//    private static JFrame window;
//    private static JPanel mainPanel;
//
//    public static void main(String[] args) {
//        setupWindow();
//        setupHeaderPanel();
//        setupClockSection();
//        setupStopwatchSection();
//        setupCountdownSection();
//        setupTimer();
//        applyTheme();  // Apply theme to all components
//        window.setVisible(true);
//    }
//
//    // ===== WINDOW SETUP =====
//    private static void setupWindow() {
//        window = new JFrame("Digital Clock & Stopwatch & Countdown Timer");
//        window.setSize(900, 750);
//        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        mainPanel = new JPanel();
//        mainPanel.setLayout(new BorderLayout(10, 10));
//
//        window.add(mainPanel);
//    }
//
//    // ===== HEADER PANEL WITH THEME TOGGLE =====
//    private static void setupHeaderPanel() {
//        JPanel headerPanel = new JPanel();
//        headerPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 10));
//
//        themeToggleBtn = new JButton("🌙 DARK MODE");
//        themeToggleBtn.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));
//        themeToggleBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                isDarkMode = !isDarkMode;  // Toggle theme
//                applyTheme();  // Apply to all components
//                updateThemeButtonText();
//            }
//        });
//
//        headerPanel.add(themeToggleBtn);
//        mainPanel.add(headerPanel, BorderLayout.NORTH);
//    }
//
//    private static void updateThemeButtonText() {
//        if (isDarkMode) {
//            themeToggleBtn.setText("🌙 DARK MODE");
//        } else {
//            themeToggleBtn.setText("☀️ LIGHT MODE");
//        }
//    }
//
//    // ===== CLOCK SECTION =====
//    private static void setupClockSection() {
//        JPanel clockPanel = new JPanel();
//        clockPanel.setLayout(new BorderLayout(0, 15));
//
//        timeLabel = new JLabel("00:00:00 AM");
//        timeLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 60));
//        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
//
//        dateLabel = new JLabel("Monday, January 15, 2025");
//        dateLabel.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 18));
//        dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
//
//        clockPanel.add(timeLabel, BorderLayout.CENTER);
//        clockPanel.add(dateLabel, BorderLayout.SOUTH);
//
//        mainPanel.add(clockPanel, BorderLayout.NORTH);
//    }
//
//    // ===== STOPWATCH SECTION =====
//    private static void setupStopwatchSection() {
//        JPanel stopwatchPanel = new JPanel();
//        stopwatchPanel.setLayout(new BorderLayout(0, 15));
//
//        // Title
//        JLabel titleLabel = new JLabel("STOPWATCH");
//        titleLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));
//        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
//
//        stopwatchLabel = new JLabel("00:00:00");
//        stopwatchLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 50));
//        stopwatchLabel.setHorizontalAlignment(SwingConstants.CENTER);
//
//        JPanel stopwatchButtonsPanel = createStopwatchButtons();
//
//        stopwatchPanel.add(titleLabel, BorderLayout.NORTH);
//        stopwatchPanel.add(stopwatchLabel, BorderLayout.CENTER);
//        stopwatchPanel.add(stopwatchButtonsPanel, BorderLayout.SOUTH);
//
//        // Will be added to timerPanel
//        mainPanel.add(stopwatchPanel, BorderLayout.CENTER);
//    }
//
//    private static JPanel createStopwatchButtons() {
//        JPanel buttonsPanel = new JPanel();
//        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));
//
//        JButton startBtn = new JButton("▶ START");
//        startBtn.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
//        startBtn.setPreferredSize(new java.awt.Dimension(120, 40));
//        startBtn.setBackground(Color.GREEN);
//        startBtn.setForeground(Color.BLACK);
//        startBtn.setFocusPainted(false);
//        startBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (!stopwatchRunning) {
//                    stopwatchRunning = true;
//                    stopwatchStartTime = System.currentTimeMillis() - elapsedMilliseconds;
//                }
//            }
//        });
//
//        JButton stopBtn = new JButton("⏸ STOP");
//        stopBtn.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
//        stopBtn.setPreferredSize(new java.awt.Dimension(120, 40));
//        stopBtn.setBackground(Color.YELLOW);
//        stopBtn.setForeground(Color.BLACK);
//        stopBtn.setFocusPainted(false);
//        stopBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (stopwatchRunning) {
//                    stopwatchRunning = false;
//                }
//            }
//        });
//
//        JButton resetBtn = new JButton("🔄 RESET");
//        resetBtn.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
//        resetBtn.setPreferredSize(new java.awt.Dimension(120, 40));
//        resetBtn.setBackground(Color.RED);
//        resetBtn.setForeground(Color.BLACK);
//        resetBtn.setFocusPainted(false);
//        resetBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                stopwatchRunning = false;
//                elapsedMilliseconds = 0;
//                stopwatchLabel.setText("00:00:00");
//            }
//        });
//
//        buttonsPanel.add(startBtn);
//        buttonsPanel.add(stopBtn);
//        buttonsPanel.add(resetBtn);
//
//        return buttonsPanel;
//    }
//
//    // ===== COUNTDOWN SECTION =====
//    private static void setupCountdownSection() {
//        JPanel countdownPanel = new JPanel();
//        countdownPanel.setLayout(new BorderLayout(0, 15));
//
//        // Title
//        JLabel titleLabel = new JLabel("COUNTDOWN TIMER");
//        titleLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));
//        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
//
//        JPanel countdownInputPanel = createCountdownInputPanel();
//
//        countdownLabel = new JLabel("01:30");
//        countdownLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 50));
//        countdownLabel.setHorizontalAlignment(SwingConstants.CENTER);
//
//        JPanel countdownButtonsPanel = createCountdownButtons();
//
//        countdownPanel.add(titleLabel, BorderLayout.NORTH);
//        countdownPanel.add(countdownInputPanel, BorderLayout.NORTH);
//        countdownPanel.add(countdownLabel, BorderLayout.CENTER);
//        countdownPanel.add(countdownButtonsPanel, BorderLayout.SOUTH);
//
//        // Add to existing center panel
//        JPanel centerPanel = new JPanel();
//        centerPanel.setLayout(new GridLayout(2, 1, 0, 20));
//        centerPanel.add((JPanel)mainPanel.getComponent(1));
//        centerPanel.add(countdownPanel);
//
//        mainPanel.remove(1);
//        mainPanel.add(centerPanel, BorderLayout.CENTER);
//    }
//
//    private static JPanel createCountdownInputPanel() {
//        JPanel inputPanel = new JPanel();
//        inputPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
//
//        JLabel inputLabel = new JLabel("Set Time: ");
//        inputLabel.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 14));
//
//        minutesField = new JTextField("01", 2);
//        minutesField.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 16));
//        minutesField.setHorizontalAlignment(SwingConstants.CENTER);
//
//        JLabel colonLabel = new JLabel(":");
//        colonLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));
//
//        secondsField = new JTextField("30", 2);
//        secondsField.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 16));
//        secondsField.setHorizontalAlignment(SwingConstants.CENTER);
//
//        JButton setTimeBtn = new JButton("SET");
//        setTimeBtn.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));
//        setTimeBtn.setBackground(Color.CYAN);
//        setTimeBtn.setForeground(Color.BLACK);
//        setTimeBtn.setFocusPainted(false);
//        setTimeBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                setCountdownTime();
//            }
//        });
//
//        inputPanel.add(inputLabel);
//        inputPanel.add(minutesField);
//        inputPanel.add(colonLabel);
//        inputPanel.add(secondsField);
//        inputPanel.add(setTimeBtn);
//
//        return inputPanel;
//    }
//
//    private static void setCountdownTime() {
//        try {
//            int minutes = Integer.parseInt(minutesField.getText());
//            int seconds = Integer.parseInt(secondsField.getText());
//
//            if (minutes < 0 || minutes > 59 || seconds < 0 || seconds > 59) {
//                countdownLabel.setText("INVALID");
//                countdownLabel.setForeground(Color.RED);
//                return;
//            }
//
//            countdownTotal = (minutes * 60 + seconds) * 1000;
//            countdownMilliseconds = countdownTotal;
//            countdownRunning = false;
//
//            countdownLabel.setText(String.format("%02d:%02d", minutes, seconds));
//            countdownLabel.setForeground(isDarkMode ? Color.MAGENTA : Color.BLUE);
//        } catch (NumberFormatException ex) {
//            countdownLabel.setText("ERROR");
//            countdownLabel.setForeground(Color.RED);
//        }
//    }
//
//    private static JPanel createCountdownButtons() {
//        JPanel buttonsPanel = new JPanel();
//        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));
//
//        JButton startBtn = new JButton("▶ START");
//        startBtn.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
//        startBtn.setPreferredSize(new java.awt.Dimension(120, 40));
//        startBtn.setBackground(Color.GREEN);
//        startBtn.setForeground(Color.BLACK);
//        startBtn.setFocusPainted(false);
//        startBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (!countdownRunning && countdownTotal > 0) {
//                    countdownRunning = true;
//                    countdownStartTime = System.currentTimeMillis();
//                }
//            }
//        });
//
//        JButton stopBtn = new JButton("⏸ STOP");
//        stopBtn.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
//        stopBtn.setPreferredSize(new java.awt.Dimension(120, 40));
//        stopBtn.setBackground(Color.YELLOW);
//        stopBtn.setForeground(Color.BLACK);
//        stopBtn.setFocusPainted(false);
//        stopBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (countdownRunning) {
//                    countdownRunning = false;
//                }
//            }
//        });
//
//        JButton resetBtn = new JButton("🔄 RESET");
//        resetBtn.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
//        resetBtn.setPreferredSize(new java.awt.Dimension(120, 40));
//        resetBtn.setBackground(Color.RED);
//        resetBtn.setForeground(Color.BLACK);
//        resetBtn.setFocusPainted(false);
//        resetBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                countdownRunning = false;
//                countdownMilliseconds = countdownTotal;
//
//                long minutes = (countdownTotal / 1000) / 60;
//                long seconds = (countdownTotal / 1000) % 60;
//                countdownLabel.setText(String.format("%02d:%02d", minutes, seconds));
//                countdownLabel.setForeground(isDarkMode ? Color.MAGENTA : Color.BLUE);
//            }
//        });
//
//        buttonsPanel.add(startBtn);
//        buttonsPanel.add(stopBtn);
//        buttonsPanel.add(resetBtn);
//
//        return buttonsPanel;
//    }
//
//    // ===== TIMER =====
//    private static void setupTimer() {
//        Timer timer = new Timer(100, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                updateClock();
//                updateStopwatch();
//                updateCountdown();
//            }
//        });
//        timer.start();
//    }
//
//    // ===== UPDATE METHODS =====
//    private static void updateClock() {
//        SimpleDateFormat timeSdf = new SimpleDateFormat("hh:mm:ss a");
//        String currentTime = timeSdf.format(new Date());
//        timeLabel.setText(currentTime);
//
//        SimpleDateFormat dateSdf = new SimpleDateFormat("EEEE, MMMM dd, yyyy");
//        String currentDate = dateSdf.format(new Date());
//        dateLabel.setText(currentDate);
//    }
//
//    private static void updateStopwatch() {
//        if (stopwatchRunning) {
//            elapsedMilliseconds = System.currentTimeMillis() - stopwatchStartTime;
//        }
//
//        long totalSeconds = elapsedMilliseconds / 1000;
//        long hours = totalSeconds / 3600;
//        long minutes = (totalSeconds % 3600) / 60;
//        long seconds = totalSeconds % 60;
//
//        String stopwatchTime = String.format("%02d:%02d:%02d", hours, minutes, seconds);
//        stopwatchLabel.setText(stopwatchTime);
//    }
//
//    private static void updateCountdown() {
//        if (countdownRunning) {
//            long elapsedSinceStart = System.currentTimeMillis() - countdownStartTime;
//            countdownMilliseconds = countdownTotal - elapsedSinceStart;
//
//            if (countdownMilliseconds <= 0) {
//                countdownMilliseconds = 0;
//                countdownRunning = false;
//                countdownLabel.setText("TIME'S UP!");
//                countdownLabel.setForeground(Color.RED);
//            }
//        }
//
//        if (countdownMilliseconds > 0) {
//            long countdownSecs = countdownMilliseconds / 1000;
//            long countdownMins = countdownSecs / 60;
//            long countdownRemainingSecs = countdownSecs % 60;
//
//            countdownLabel.setText(String.format("%02d:%02d", countdownMins, countdownRemainingSecs));
//            if (!countdownLabel.getText().equals("TIME'S UP!")) {
//                countdownLabel.setForeground(isDarkMode ? Color.MAGENTA : Color.BLUE);
//            }
//        }
//    }
//
//    // ===== THEME SYSTEM =====
//    private static void applyTheme() {
//        Color bgColor = getBackgroundColor();
//        Color textColor = getTextColor();
//        Color accentColor = getAccentColor();
//
//        // Apply to main panel
//        mainPanel.setBackground(bgColor);
//
//        // Apply to header
//        JPanel headerPanel = (JPanel) mainPanel.getComponent(0);
//        headerPanel.setBackground(bgColor);
//
//        applyThemeToComponent(headerPanel, bgColor, textColor);
//
//        // Apply to all child components recursively
//        applyThemeToAllComponents(mainPanel, bgColor, textColor, accentColor);
//    }
//
//    private static void applyThemeToAllComponents(java.awt.Container container, Color bg, Color text, Color accent) {
//        for (java.awt.Component comp : container.getComponents()) {
//            if (comp instanceof JPanel) {
//                ((JPanel) comp).setBackground(bg);
//                applyThemeToAllComponents((JPanel) comp, bg, text, accent);
//            } else if (comp instanceof JLabel) {
//                ((JLabel) comp).setForeground(text);
//            } else if (comp instanceof JButton) {
//                // Keep button colors as designed
//            } else if (comp instanceof JTextField) {
//                ((JTextField) comp).setBackground(bg);
//                ((JTextField) comp).setForeground(text);
//                ((JTextField) comp).setCaretColor(text);
//            }
//        }
//    }
//
//    private static void applyThemeToComponent(java.awt.Container comp, Color bg, Color text) {
//        for (java.awt.Component c : comp.getComponents()) {
//            if (c instanceof JPanel) {
//                ((JPanel) c).setBackground(bg);
//            } else if (c instanceof JLabel) {
//                ((JLabel) c).setForeground(text);
//            } else if (c instanceof JButton) {
//                // Keep button colors
//            }
//        }
//    }
//
//    private static Color getBackgroundColor() {
//        return isDarkMode ? Color.BLACK : new Color(240, 240, 240);  // Light gray
//    }
//
//    private static Color getTextColor() {
//        return isDarkMode ? Color.WHITE : Color.BLACK;
//    }
//
//    private static Color getAccentColor() {
//        return isDarkMode ? Color.CYAN : Color.BLUE;
//    }
//}
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.SwingConstants;

/**
 * Digital Clock Application with Stopwatch and Countdown Timer
 *
 * A comprehensive Java Swing application featuring:
 * - Live digital clock with current date
 * - Stopwatch with start/stop/reset and lap time recording
 * - Countdown timer with user input
 * - Dark/Light theme toggle
 * - Professional UI with color schemes
 *
 * @author Your Name
 * @version 1.0
 */
public class DigitalClock {

    // ===== THEME SETTINGS =====
    private static boolean isDarkMode = true;

    // ===== STOPWATCH VARIABLES =====
    private static long elapsedMilliseconds = 0;
    private static boolean stopwatchRunning = false;
    private static long stopwatchStartTime = 0;

    // ===== LAP TIMES VARIABLES =====
    private static java.util.ArrayList<String> lapTimes = new java.util.ArrayList<>();
    private static JTextArea lapTimesDisplay;

    // ===== COUNTDOWN VARIABLES =====
    private static long countdownMilliseconds = 0;
    private static boolean countdownRunning = false;
    private static long countdownStartTime = 0;
    private static long countdownTotal = 0;

    // ===== UI COMPONENTS =====
    private static JLabel timeLabel;
    private static JLabel dateLabel;
    private static JLabel stopwatchLabel;
    private static JLabel countdownLabel;
    private static JTextField minutesField;
    private static JTextField secondsField;
    private static JButton themeToggleBtn;

    // ===== MAIN CONTAINERS =====
    private static JFrame window;
    private static JPanel mainPanel;

    /**
     * Main entry point for the Digital Clock application.
     * Initializes all UI components and starts the application.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        setupWindow();
        setupHeaderPanel();
        setupClockSection();
        setupStopwatchSection();
        setupCountdownSection();
        setupTimer();
        applyTheme();
        window.setVisible(true);
    }

    // ===== SETUP METHODS =====

    /**
     * Creates and initializes the main application window.
     *
     * Establishes a JFrame with dimensions 900x750 pixels and configures
     * the BorderLayout. Initializes the main panel with proper spacing
     * that will contain all UI sections.
     */
    private static void setupWindow() {
        window = new JFrame("Digital Clock & Stopwatch & Countdown Timer");
        window.setSize(900, 750);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));

        window.add(mainPanel);
    }

    /**
     * Creates the header panel with theme toggle button.
     *
     * Sets up the top section containing the dark/light mode toggle button
     * that allows users to switch between themes instantly.
     */
    private static void setupHeaderPanel() {
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 10));

        themeToggleBtn = new JButton("🌙 DARK MODE");
        themeToggleBtn.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));
        themeToggleBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isDarkMode = !isDarkMode;
                applyTheme();
                updateThemeButtonText();
            }
        });

        headerPanel.add(themeToggleBtn);
        mainPanel.add(headerPanel, BorderLayout.NORTH);
    }

    /**
     * Updates the theme toggle button text based on current theme.
     *
     * Changes button text between "🌙 DARK MODE" and "☀️ LIGHT MODE"
     * to reflect the current active theme.
     */
    private static void updateThemeButtonText() {
        if (isDarkMode) {
            themeToggleBtn.setText("🌙 DARK MODE");
        } else {
            themeToggleBtn.setText("☀️ LIGHT MODE");
        }
    }

    /**
     * Creates and configures the clock display section.
     *
     * Sets up labels for displaying current time in 12-hour format
     * with AM/PM indicator and current date with full day and month names.
     */
    private static void setupClockSection() {
        JPanel clockPanel = new JPanel();
        clockPanel.setLayout(new BorderLayout(0, 15));

        timeLabel = new JLabel("00:00:00 AM");
        timeLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 60));
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        dateLabel = new JLabel("Monday, January 15, 2025");
        dateLabel.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 18));
        dateLabel.setHorizontalAlignment(SwingConstants.CENTER);

        clockPanel.add(timeLabel, BorderLayout.CENTER);
        clockPanel.add(dateLabel, BorderLayout.SOUTH);

        mainPanel.add(clockPanel, BorderLayout.NORTH);
    }

    /**
     * Creates and configures the stopwatch display section with lap times.
     *
     * Sets up the stopwatch display label, control buttons (including LAP button),
     * and a text area for displaying recorded lap times. Uses BorderLayout to organize
     * stopwatch controls above the lap times display.
     */
    private static void setupStopwatchSection() {
        JPanel stopwatchPanel = new JPanel();
        stopwatchPanel.setLayout(new BorderLayout(0, 15));

        JLabel titleLabel = new JLabel("STOPWATCH");
        titleLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        stopwatchLabel = new JLabel("00:00:00");
        stopwatchLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 50));
        stopwatchLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel stopwatchButtonsPanel = createStopwatchButtons();

        // ===== LAP TIMES DISPLAY =====
        lapTimesDisplay = new JTextArea(5, 20);
        lapTimesDisplay.setEditable(false);
        lapTimesDisplay.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 12));
        lapTimesDisplay.setText("No laps yet");
        lapTimesDisplay.setLineWrap(true);
        lapTimesDisplay.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(lapTimesDisplay);

        stopwatchPanel.add(titleLabel, BorderLayout.NORTH);
        stopwatchPanel.add(stopwatchLabel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(stopwatchButtonsPanel, BorderLayout.NORTH);
        bottomPanel.add(scrollPane, BorderLayout.CENTER);

        stopwatchPanel.add(bottomPanel, BorderLayout.SOUTH);

        mainPanel.add(stopwatchPanel, BorderLayout.CENTER);
    }

    /**
     * Creates the stopwatch control buttons including start, lap, stop, and reset.
     *
     * Builds a panel containing four buttons: START (green), LAP (cyan), STOP (yellow),
     * and RESET (red). Each button has an ActionListener that manages stopwatch state.
     * The LAP button records the current elapsed time to the lap times list.
     *
     * @return JPanel containing the four stopwatch control buttons
     */
    private static JPanel createStopwatchButtons() {
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));

        JButton startBtn = new JButton("▶ START");
        startBtn.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
        startBtn.setPreferredSize(new java.awt.Dimension(120, 40));
        startBtn.setBackground(Color.GREEN);
        startBtn.setForeground(Color.BLACK);
        startBtn.setFocusPainted(false);
        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!stopwatchRunning) {
                    stopwatchRunning = true;
                    stopwatchStartTime = System.currentTimeMillis() - elapsedMilliseconds;
                }
            }
        });

        // ===== LAP BUTTON =====
        JButton lapBtn = new JButton("🏁 LAP");
        lapBtn.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
        lapBtn.setPreferredSize(new java.awt.Dimension(120, 40));
        lapBtn.setBackground(Color.CYAN);
        lapBtn.setForeground(Color.BLACK);
        lapBtn.setFocusPainted(false);
        lapBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recordLapTime();
            }
        });

        JButton stopBtn = new JButton("⏸ STOP");
        stopBtn.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
        stopBtn.setPreferredSize(new java.awt.Dimension(120, 40));
        stopBtn.setBackground(Color.YELLOW);
        stopBtn.setForeground(Color.BLACK);
        stopBtn.setFocusPainted(false);
        stopBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (stopwatchRunning) {
                    stopwatchRunning = false;
                }
            }
        });

        JButton resetBtn = new JButton("🔄 RESET");
        resetBtn.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
        resetBtn.setPreferredSize(new java.awt.Dimension(120, 40));
        resetBtn.setBackground(Color.RED);
        resetBtn.setForeground(Color.BLACK);
        resetBtn.setFocusPainted(false);
        resetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopwatchRunning = false;
                elapsedMilliseconds = 0;
                stopwatchLabel.setText("00:00:00");
                lapTimes.clear();
                lapTimesDisplay.setText("No laps yet");
            }
        });

        buttonsPanel.add(startBtn);
        buttonsPanel.add(lapBtn);
        buttonsPanel.add(stopBtn);
        buttonsPanel.add(resetBtn);

        return buttonsPanel;
    }

    /**
     * Creates and configures the countdown timer section.
     *
     * Sets up input fields for minutes and seconds, countdown display label,
     * and control buttons. Arranges stopwatch and countdown sections vertically
     * using GridLayout.
     */
    private static void setupCountdownSection() {
        JPanel countdownPanel = new JPanel();
        countdownPanel.setLayout(new BorderLayout(0, 15));

        JLabel titleLabel = new JLabel("COUNTDOWN TIMER");
        titleLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel countdownInputPanel = createCountdownInputPanel();

        countdownLabel = new JLabel("01:30");
        countdownLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 50));
        countdownLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel countdownButtonsPanel = createCountdownButtons();

        countdownPanel.add(titleLabel, BorderLayout.NORTH);
        countdownPanel.add(countdownInputPanel, BorderLayout.NORTH);
        countdownPanel.add(countdownLabel, BorderLayout.CENTER);
        countdownPanel.add(countdownButtonsPanel, BorderLayout.SOUTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(2, 1, 0, 20));
        centerPanel.add((JPanel)mainPanel.getComponent(1));
        centerPanel.add(countdownPanel);

        mainPanel.remove(1);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
    }

    /**
     * Creates the countdown timer input panel with time entry fields.
     *
     * Builds a panel containing text fields for minutes and seconds entry
     * and a SET button to confirm the countdown duration.
     *
     * @return JPanel containing minute/second input fields and SET button
     */
    private static JPanel createCountdownInputPanel() {
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));

        JLabel inputLabel = new JLabel("Set Time: ");
        inputLabel.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 14));

        minutesField = new JTextField("01", 2);
        minutesField.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 16));
        minutesField.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel colonLabel = new JLabel(":");
        colonLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));

        secondsField = new JTextField("30", 2);
        secondsField.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 16));
        secondsField.setHorizontalAlignment(SwingConstants.CENTER);

        JButton setTimeBtn = new JButton("SET");
        setTimeBtn.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));
        setTimeBtn.setBackground(Color.CYAN);
        setTimeBtn.setForeground(Color.BLACK);
        setTimeBtn.setFocusPainted(false);
        setTimeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCountdownTime();
            }
        });

        inputPanel.add(inputLabel);
        inputPanel.add(minutesField);
        inputPanel.add(colonLabel);
        inputPanel.add(secondsField);
        inputPanel.add(setTimeBtn);

        return inputPanel;
    }

    /**
     * Parses user input and sets the countdown timer duration.
     *
     * Reads values from minute and second input fields, validates them
     * (0-59 range), converts to milliseconds, and updates the display.
     * Shows error message if input is invalid.
     */
    private static void setCountdownTime() {
        try {
            int minutes = Integer.parseInt(minutesField.getText());
            int seconds = Integer.parseInt(secondsField.getText());

            if (minutes < 0 || minutes > 59 || seconds < 0 || seconds > 59) {
                countdownLabel.setText("INVALID");
                countdownLabel.setForeground(Color.RED);
                return;
            }

            countdownTotal = (minutes * 60 + seconds) * 1000;
            countdownMilliseconds = countdownTotal;
            countdownRunning = false;

            countdownLabel.setText(String.format("%02d:%02d", minutes, seconds));
            countdownLabel.setForeground(isDarkMode ? Color.MAGENTA : Color.BLUE);
        } catch (NumberFormatException ex) {
            countdownLabel.setText("ERROR");
            countdownLabel.setForeground(Color.RED);
        }
    }

    /**
     * Creates the countdown timer control buttons.
     *
     * Builds a panel containing start, stop, and reset buttons for the countdown.
     * Each button has an ActionListener that manages countdown state and display.
     *
     * @return JPanel containing the three countdown control buttons
     */
    private static JPanel createCountdownButtons() {
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));

        JButton startBtn = new JButton("▶ START");
        startBtn.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
        startBtn.setPreferredSize(new java.awt.Dimension(120, 40));
        startBtn.setBackground(Color.GREEN);
        startBtn.setForeground(Color.BLACK);
        startBtn.setFocusPainted(false);
        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!countdownRunning && countdownTotal > 0) {
                    countdownRunning = true;
                    countdownStartTime = System.currentTimeMillis();
                }
            }
        });

        JButton stopBtn = new JButton("⏸ STOP");
        stopBtn.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
        stopBtn.setPreferredSize(new java.awt.Dimension(120, 40));
        stopBtn.setBackground(Color.YELLOW);
        stopBtn.setForeground(Color.BLACK);
        stopBtn.setFocusPainted(false);
        stopBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (countdownRunning) {
                    countdownRunning = false;
                }
            }
        });

        JButton resetBtn = new JButton("🔄 RESET");
        resetBtn.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
        resetBtn.setPreferredSize(new java.awt.Dimension(120, 40));
        resetBtn.setBackground(Color.RED);
        resetBtn.setForeground(Color.BLACK);
        resetBtn.setFocusPainted(false);
        resetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countdownRunning = false;
                countdownMilliseconds = countdownTotal;

                long minutes = (countdownTotal / 1000) / 60;
                long seconds = (countdownTotal / 1000) % 60;
                countdownLabel.setText(String.format("%02d:%02d", minutes, seconds));
                countdownLabel.setForeground(isDarkMode ? Color.MAGENTA : Color.BLUE);
            }
        });

        buttonsPanel.add(startBtn);
        buttonsPanel.add(stopBtn);
        buttonsPanel.add(resetBtn);

        return buttonsPanel;
    }

    /**
     * Initializes and starts the main application timer.
     *
     * Creates a Timer that triggers every 100 milliseconds, calling update methods
     * for clock, stopwatch, and countdown. This provides smooth display updates
     * for all three components.
     */
    private static void setupTimer() {
        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateClock();
                updateStopwatch();
                updateCountdown();
            }
        });
        timer.start();
    }

    // ===== UPDATE METHODS =====

    /**
     * Updates the clock display with current system time and date.
     *
     * Retrieves the current time in 12-hour format with AM/PM indicator
     * and the current date with full day and month names.
     * Called every 100ms by the main timer.
     */
    private static void updateClock() {
        SimpleDateFormat timeSdf = new SimpleDateFormat("hh:mm:ss a");
        String currentTime = timeSdf.format(new Date());
        timeLabel.setText(currentTime);

        SimpleDateFormat dateSdf = new SimpleDateFormat("EEEE, MMMM dd, yyyy");
        String currentDate = dateSdf.format(new Date());
        dateLabel.setText(currentDate);
    }

    /**
     * Updates the stopwatch display with the current elapsed time.
     *
     * Calculates elapsed milliseconds since the stopwatch started (if running),
     * converts the time to HH:MM:SS format, and updates the display label.
     * This method is called every 100 milliseconds by the main timer
     * to provide smooth, continuous updates.
     */
    private static void updateStopwatch() {
        if (stopwatchRunning) {
            elapsedMilliseconds = System.currentTimeMillis() - stopwatchStartTime;
        }

        long totalSeconds = elapsedMilliseconds / 1000;
        long hours = totalSeconds / 3600;
        long minutes = (totalSeconds % 3600) / 60;
        long seconds = totalSeconds % 60;

        String stopwatchTime = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        stopwatchLabel.setText(stopwatchTime);
    }

    /**
     * Updates the countdown timer display with remaining time.
     *
     * If countdown is running, calculates remaining milliseconds by subtracting
     * elapsed time from total duration. Formats time as MM:SS and updates the label.
     * When time reaches zero, displays "TIME'S UP!" in red and plays alarm sound.
     * This method is called every 100 milliseconds by the main timer.
     */
    private static void updateCountdown() {
        if (countdownRunning) {
            long elapsedSinceStart = System.currentTimeMillis() - countdownStartTime;
            countdownMilliseconds = countdownTotal - elapsedSinceStart;

            if (countdownMilliseconds <= 0) {
                countdownMilliseconds = 0;
                countdownRunning = false;
                countdownLabel.setText("TIME'S UP!");
                countdownLabel.setForeground(Color.RED);
                playAlarmSound();
            }
        }

b         if (countdownMilliseconds > 0) {
            long countdownSecs = countdownMilliseconds / 1000;
            long countdownMins = countdownSecs / 60;
            long countdownRemainingSecs = countdownSecs % 60;

            countdownLabel.setText(String.format("%02d:%02d", countdownMins, countdownRemainingSecs));
            if (!countdownLabel.getText().equals("TIME'S UP!")) {
                countdownLabel.setForeground(isDarkMode ? Color.MAGENTA : Color.BLUE);
            }
        }
    }

    // ===== LAP TIMES METHODS =====

    /**
     * Records the current stopwatch elapsed time as a new lap entry.
     *
     * Captures the current elapsed milliseconds, formats it as HH:MM:SS,
     * adds it to the lap times list with a sequential lap number, and updates
     * the lap times display area. Only records laps while stopwatch is running.
     */
    private static void recordLapTime() {
        if (stopwatchRunning) {
            // Format current elapsed time as HH:MM:SS
            long totalSeconds = elapsedMilliseconds / 1000;
            long hours = totalSeconds / 3600;
            long minutes = (totalSeconds % 3600) / 60;
            long seconds = totalSeconds % 60;

            String lapTime = String.format("%02d:%02d:%02d", hours, minutes, seconds);

            // Create lap entry with number and time
            int lapNumber = lapTimes.size() + 1;
            String lapEntry = "Lap " + lapNumber + ": " + lapTime;
            lapTimes.add(lapEntry);

            // Update the display to show all laps
            updateLapDisplay();
        }
    }

    /**
     * Updates the lap times display area with all recorded laps.
     *
     * Formats all lap entries from the ArrayList into a readable text format
     * and displays them in the lap times text area. Shows "No laps yet" if
     * no laps have been recorded.
     */
    private static void updateLapDisplay() {
        if (lapTimes.isEmpty()) {
            lapTimesDisplay.setText("No laps yet");
        } else {
            StringBuilder display = new StringBuilder("LAP TIMES:\n");
            for (String lap : lapTimes) {
                display.append(lap).append("\n");
            }
            lapTimesDisplay.setText(display.toString());
        }
    }

    // ===== ALARM SOUND METHOD =====

    /**
     * Plays an alarm sound when countdown timer reaches zero.
     *
     * Produces multiple beep sounds with delays to create an alarm effect.
     * The alarm beeps 5 times with 500 millisecond pauses between each beep.
     * Runs in a separate thread to avoid freezing the UI during playback.
     */
    private static void playAlarmSound() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                // Play 5 beeps
                for (int i = 0; i < 5; i++) {
                    // Play the beep sound
                    java.awt.Toolkit.getDefaultToolkit().beep();

                    // Wait 500 milliseconds (0.5 seconds) before next beep
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    // ===== THEME SYSTEM =====

    /**
     * Applies the current theme (dark or light mode) to all UI components.
     *
     * Checks the isDarkMode flag to determine appropriate colors for background
     * and text. Recursively updates all panels, labels, text fields, and buttons
     * throughout the application. Called when user clicks the theme toggle button
     * or when application starts.
     */
    private static void applyTheme() {
        Color bgColor = getBackgroundColor();
        Color textColor = getTextColor();
        Color accentColor = getAccentColor();

        mainPanel.setBackground(bgColor);

        JPanel headerPanel = (JPanel) mainPanel.getComponent(0);
        headerPanel.setBackground(bgColor);

        applyThemeToComponent(headerPanel, bgColor, textColor);
        applyThemeToAllComponents(mainPanel, bgColor, textColor, accentColor);
    }

    /**
     * Recursively applies theme colors to all components in a container.
     *
     * Traverses the component tree and updates background/text colors for
     * panels, labels, text fields, and other UI elements based on the
     * current theme setting.
     *
     * @param container The parent component to process
     * @param bg Background color to apply
     * @param text Text/foreground color to apply
     * @param accent Accent color for special elements
     */
    private static void applyThemeToAllComponents(java.awt.Container container, Color bg, Color text, Color accent) {
        for (java.awt.Component comp : container.getComponents()) {
            if (comp instanceof JPanel) {
                ((JPanel) comp).setBackground(bg);
                applyThemeToAllComponents((JPanel) comp, bg, text, accent);
            } else if (comp instanceof JLabel) {
                ((JLabel) comp).setForeground(text);
            } else if (comp instanceof JButton) {
                // Keep button colors as designed
            } else if (comp instanceof JTextField) {
                ((JTextField) comp).setBackground(bg);
                ((JTextField) comp).setForeground(text);
                ((JTextField) comp).setCaretColor(text);
            } else if (comp instanceof JTextArea) {
                ((JTextArea) comp).setBackground(bg);
                ((JTextArea) comp).setForeground(text);
            }
        }
    }

    /**
     * Applies theme colors to a specific component and its immediate children.
     *
     * @param comp The container component to process
     * @param bg Background color to apply
     * @param text Text/foreground color to apply
     */
    private static void applyThemeToComponent(java.awt.Container comp, Color bg, Color text) {
        for (java.awt.Component c : comp.getComponents()) {
            if (c instanceof JPanel) {
                ((JPanel) c).setBackground(bg);
            } else if (c instanceof JLabel) {
                ((JLabel) c).setForeground(text);
            } else if (c instanceof JButton) {
                // Keep button colors
            } else if (c instanceof JTextArea) {
                ((JTextArea) c).setBackground(bg);
                ((JTextArea) c).setForeground(text);
            }
        }
    }

    /**
     * Determines the background color based on current theme.
     *
     * @return Black for dark mode, light gray for light mode
     */
    private static Color getBackgroundColor() {
        return isDarkMode ? Color.BLACK : new Color(240, 240, 240);
    }

    /**
     * Determines the text color based on current theme.
     *
     * @return White for dark mode, black for light mode
     */
    private static Color getTextColor() {
        return isDarkMode ? Color.WHITE : Color.BLACK;
    }

    /**
     * Determines the accent color based on current theme.
     *
     * @return Cyan for dark mode, blue for light mode
     */
    private static Color getAccentColor() {
        return isDarkMode ? Color.CYAN : Color.BLUE;
    }
}
