# Bridge Score Calculator

A desktop Java application that simulates card deals and calculates hand strength using the **Milton Work Count** (HCP) and distribution logic.


## Key Features
- **Object-Oriented Design**: Clean separation between data models (`Card`, `Deck`, `Hand`) and the GUI.
- **Automated Scoring**: Calculates points for high cards (A=4, K=3, Q=2, J=1) and hand distribution.
- **Responsive GUI**: Developed using Java Swing with `GridBagLayout` for consistent component alignment.
- **Resource Management**: Custom graphical icons for card suits loaded from project resources.


## Project Structure
- `src/com/company/`: Contains the source code.
- `resources/`: Contains suit icons (.png).
- `.gitignore`: Configured to exclude IDE-specific and build files.

## How to Run
1. Clone the repository.
2. Ensure you have Java 17 or newer installed.
3. Open the project in your IDE (e.g., IntelliJ IDEA).
4. Run `BridgeGame.java`.
