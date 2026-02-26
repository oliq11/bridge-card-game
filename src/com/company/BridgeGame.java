package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class BridgeGame extends JFrame {
    private final HashMap<Card.Suit, JTextField> fields = new HashMap<>();
    private final JLabel pointsLabel = new JLabel("Punkty: 0", SwingConstants.CENTER);

    public BridgeGame() {
        setTitle("Bridge Scorer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        int row = 0;
        for (Card.Suit suit : Card.Suit.values()) {
            gbc.gridx = 0; gbc.gridy = row;

            ImageIcon icon = loadIcon(suit);
            if (icon != null) {
                add(new JLabel(icon), gbc);
            } else {
                add(new JLabel(suit.getName() + ":"), gbc);
            }

            JTextField field = new JTextField(15);
            fields.put(suit, field);
            gbc.gridx = 1;
            add(field, gbc);
            row++;
        }

        JButton dealBtn = new JButton("Losuj karty");
        dealBtn.addActionListener(e -> performDeal());

        gbc.gridx = 0; gbc.gridy = row;
        gbc.gridwidth = 2;
        add(dealBtn, gbc);

        pointsLabel.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridy = row + 1;
        add(pointsLabel, gbc);

        pack();
        setLocationRelativeTo(null);
    }

    private ImageIcon loadIcon(Card.Suit suit) {
        String path = "resources/" + suit.name().toLowerCase() + ".png";
        try {
            ImageIcon icon = new ImageIcon(path);
            if (icon.getIconWidth() == -1) return null;
            Image img = icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
            return new ImageIcon(img);
        } catch (Exception e) {
            return null;
        }
    }

    private void performDeal() {
        Deck deck = new Deck();
        Hand hand = new Hand(deck.deal(13));

        for (Card.Suit suit : Card.Suit.values()) {
            fields.get(suit).setText(hand.getCardsBySuit(suit));
        }
        pointsLabel.setText("Punkty: " + hand.calculateTotalPoints());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BridgeGame().setVisible(true));
    }
}