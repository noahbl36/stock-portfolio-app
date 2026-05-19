import javafx.application.Application;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import java.util.ArrayList;

public class StockMarketPortfolioTracker extends Application{
    // Fields
    private TextField stockName;
    private TextField stockPrice;
    private ArrayList<String> stockPortfolio = new ArrayList<String>();
    private String stockLine;
    private TextArea portfolio;
    private TextField yearlyIncome;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage){

        // Creates the start menu.
        Label welcomeLabel = new Label("Welcome to the Stock Market Portfolio Tracker! Please select an option.");
        Button goToAdd = new Button("Add");
        Button view = new Button("View");
        Button suggest = new Button("Suggest");
        Button quit = new Button("Quit");
        HBox buttons = new HBox(10, goToAdd, view, suggest, quit);
        buttons.setAlignment(Pos.CENTER);
        VBox mainMenu = new VBox (10, welcomeLabel, buttons);
        mainMenu.setAlignment(Pos.CENTER);
        Scene scene = new Scene(mainMenu, 600, 300);

        // Handles pressing of the "Add" button.
        goToAdd.setOnAction(event -> {
            Label ticker = new Label("Enter the ticker");
            Label price = new Label("Enter the stock price");
            stockName = new TextField();
            stockPrice = new TextField();
            Label addedLabel = new Label();
            HBox addedLabelHBox = new HBox(addedLabel);
            addedLabelHBox.setAlignment(Pos.CENTER);
            Button add =  new Button("Add");

            // Adds the stock to your portfolio.
            add.setOnAction(addEvent -> {
                
		// Handles empty input.
                if(stockName.getText() == "" || stockPrice.getText() == ""){
                    addedLabel.setText("You must enter a ticker and price.");
                }
                else{
                    stockLine = "Ticker: " + stockName.getText() + " || " + "Price: $" + stockPrice.getText();
                    stockPortfolio.add(stockLine);
                    addedLabel.setText("Stock was added to your portfolio!");
                }
                    });
            Button back = new Button("Back");
            back.setOnAction(backEvent -> {
                stage.setScene(scene);
                    });
            HBox addMenuButtons = new HBox(10, add, back);
            addMenuButtons.setAlignment(Pos.CENTER);
            VBox addStock = new VBox(10, ticker, stockName, price, stockPrice, addMenuButtons, addedLabelHBox);
            Scene addMenu = new Scene(addStock, 600, 300);
            stage.setScene(addMenu);
                });

        // Handles pressing of the "View" button.
        view.setOnAction(event -> {
            portfolio = new TextArea();
            Button back = new Button("Back");
            back.setOnAction(backEvent -> {
                stage.setScene(scene);
            });
            VBox viewLayout = new VBox(10, portfolio, back);
            viewLayout.setAlignment(Pos.CENTER);
            Scene viewMenu = new Scene(viewLayout, 600, 300);
            fillTextArea();
            stage.setScene(viewMenu);
                });

        // Handles pressing of the "Suggest" button.
        suggest.setOnAction(event -> {
            Label resultLabel = new Label();
            Label yearlyIncomeLabel = new Label("Enter your yearly income");
            yearlyIncome = new TextField();
            Button enter = new Button("Enter");

            // Handles the pressing of the "Enter" button.
            enter.setOnAction(enterEvent ->{
                try {
                    double income = Double.parseDouble(yearlyIncome.getText());
                    if (income <= 60000) {
                        resultLabel.setText("You should invest in HBAN!");
                    } else if (income <= 65000) {
                        resultLabel.setText("You should invest in T!");
                    } else if (income <= 70000) {
                        resultLabel.setText("You should invest in NKE!");
                    } else if (income <= 80000) {
                        resultLabel.setText("You should invest in DIS!");
                    } else if (income <= 90000) {
                        resultLabel.setText("You should invest in XOM");
                    } else if (income <= 100000) {
                        resultLabel.setText("You should invest in NVDA!");
                    } else if (income <= 110000) {
                        resultLabel.setText("You should invest in HD!");
                    } else if (income <= 120000) {
                        resultLabel.setText("You should invest in AAPL!");
                    } else {
                        resultLabel.setText("You should invest in TSLA!");
                    }
                }
                catch(NumberFormatException e){
                    resultLabel.setText("Please enter a number.");
                }
            });
            Button back = new Button("Back");
            back.setOnAction(backEvent -> {
                stage.setScene(scene);
            });
            HBox buttonsSuggestMenu = new HBox(10, enter, back);
            buttonsSuggestMenu.setAlignment(Pos.CENTER);
            HBox resultLabelHBox = new HBox(10, resultLabel);
            resultLabelHBox.setAlignment(Pos.CENTER);
            VBox suggestMenuLayout = new VBox(10, yearlyIncomeLabel, yearlyIncome, buttonsSuggestMenu, resultLabelHBox);
            Scene suggestMenu = new Scene(suggestMenuLayout, 600, 300);
            stage.setScene(suggestMenu);
                });

        // Quit button exits the program and displays a console message.
        quit.setOnAction(quitEvent ->{
            stage.close();
            System.out.println("Thank you for using the Stock Market Portfolio Tracker!");
                });
        stage.setScene(scene);
        stage.setTitle("Stock Market Portfolio Tracker");
        stage.show();
    }

    public void fillTextArea(){
        for(String stock : stockPortfolio){
            portfolio.appendText(stock + "\n");
        }
    }
}
