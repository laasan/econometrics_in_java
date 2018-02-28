import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.stage.Stage;

import javax.activation.DataSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class ChartExamples extends Application {
    final static String belgium = "Belgium";
    final static String france = "France";
    final static String germany = "Germany";
    final static String netherlands = "Netherlands";
    final static String sweden = "Sweden";
    final static String unitedKingdom = "United Kingdom";

    final XYChart.Series<String, Number> series1 =
            new XYChart.Series<>();
    final XYChart.Series<String, Number> series2 =
            new XYChart.Series<>();
    final XYChart.Series<String, Number> series3 =
            new XYChart.Series<>();
    final XYChart.Series<String, Number> series4 =
            new XYChart.Series<>();
    final XYChart.Series<String, Number> series5 =
            new XYChart.Series<>();
    final XYChart.Series<String, Number> series6 =
            new XYChart.Series<>();

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {
        //simpleIndexChart(stage);
        //simpleBarChartByCountry(stage);
        //simpleBarChartByYear(stage);
        //stackedGraphExample(stage);
        //pieChartSample(stage);
        //sampleScatterChart(stage);
        histogramSample(stage);
    }

    public void simpleIndexChart (Stage stage) {
        stage.setTitle("Index Chart");
        final XYChart.Series<String, Number> series =
                new XYChart.Series<>();

        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis =
                new NumberAxis(8000000, 11000000, 1000000);

        yAxis.setLabel("Population");
        final LineChart<String, Number> lineChart
                = new LineChart<>(xAxis, yAxis);

        lineChart.setTitle("Belgium Population");

        series.setName("Population");
        addDataItem(series, "1950", 8639369);
        addDataItem(series, "1960", 9118700);
        addDataItem(series, "1970", 9637800);
        addDataItem(series, "1980", 9846800);
        addDataItem(series, "1990", 9969310);
        addDataItem(series, "2000", 10263618);

        Scene scene = new Scene(lineChart, 800, 600);
        lineChart.getData().add(series);
        stage.setScene(scene);
        stage.show();
    }

    public void simpleBarChartByCountry(Stage stage) {
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();

        stage.setTitle("Bar Chart");
        final BarChart<String, Number> barChart
                = new BarChart<>(xAxis, yAxis);
        barChart.setTitle("Country Summary");
        xAxis.setLabel("Country");
        yAxis.setLabel("Population");

        series1.setName("1950");
        addDataItem(series1,belgium, 8639369);
        addDataItem(series1,france, 42518000);
        addDataItem(series1,germany, 68374572);
        addDataItem(series1,netherlands, 10113527);
        addDataItem(series1,sweden, 7014005);
        addDataItem(series1,unitedKingdom, 50127000);
        series2.setName("1960");
        addDataItem(series2,belgium, 9118700);
        addDataItem(series2,france, 46584000);
        addDataItem(series2,germany, 72480869);
        addDataItem(series2,netherlands, 11486000);
        addDataItem(series2,sweden, 7480395);
        addDataItem(series2,unitedKingdom, 52372000);
        series3.setName("1970");
        addDataItem(series3,belgium, 9637800);
        addDataItem(series3,france, 51918000);
        addDataItem(series3,germany, 77783164);
        addDataItem(series3,netherlands, 13032335);
        addDataItem(series3,sweden, 8042803);
        addDataItem(series3,unitedKingdom, 55632000);

        Scene scene = new Scene(barChart, 800, 600);
        barChart.getData().addAll(series1, series2, series3);
        stage.setScene(scene);
        stage.show();
    }

    public void simpleBarChartByYear(Stage stage) {
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();

        String year1950 = "1950";
        String year1960 = "1960";
        String year1970 = "1970";

        series1.setName(belgium);
        addDataItem(series1, year1950, 8639369);
        addDataItem(series1, year1960, 9118700);
        addDataItem(series1, year1970, 9637800);
        series2.setName(france);
        addDataItem(series2, year1950, 42518000);
        addDataItem(series2, year1960, 46584000);
        addDataItem(series2, year1970, 51918000);
        series3.setName(germany);
        addDataItem(series3, year1950, 68374572);
        addDataItem(series3, year1960, 72480869);
        addDataItem(series3, year1970, 77783164);
        series4.setName(netherlands);
        addDataItem(series4, year1950, 10113527);
        addDataItem(series4, year1960, 11486000);
        addDataItem(series4, year1970, 13032335);
        series5.setName(sweden);
        addDataItem(series5, year1950, 7014005);
        addDataItem(series5, year1960, 7480395);
        addDataItem(series5, year1970, 8042803);
        series6.setName(unitedKingdom);
        addDataItem(series6, year1950, 50127000);
        addDataItem(series6, year1960, 52372000);
        addDataItem(series6, year1970, 55632000);

        stage.setTitle("Bar Chart");
        final BarChart<String, Number> barChart
                = new BarChart<>(xAxis, yAxis);
        barChart.setTitle("Year Summary");
        xAxis.setLabel("Year");
        yAxis.setLabel("Population");

        Scene scene = new Scene(barChart, 800, 600);
        barChart.getData().addAll(series1, series2,
                series3, series4, series5, series6);
        stage.setScene(scene);
        stage.show();
    }

    public void stackedGraphExample(Stage stage) {
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();

        stage.setTitle("Stacked Bar Chart");
        final StackedBarChart<String, Number> stackedBarChart
                = new StackedBarChart<>(xAxis, yAxis);
        stackedBarChart.setTitle("Country Population");
        xAxis.setLabel("Country");
        xAxis.setCategories(
                FXCollections.<String>observableArrayList(
                        Arrays.asList(belgium, germany, france,
                                netherlands, sweden, unitedKingdom)));
        yAxis.setLabel("Population");

        series1.setName("1950");
        addDataItem(series1, belgium, 8639369);
        addDataItem(series1, france, 42518000);
        addDataItem(series1, germany, 68374572);
        addDataItem(series1, netherlands, 10113527);
        addDataItem(series1, sweden, 7014005);
        addDataItem(series1, unitedKingdom, 50127000);
        series2.setName("1960");
        addDataItem(series2, belgium, 9118700);
        addDataItem(series2, france, 46584000);
        addDataItem(series2, germany, 72480869);
        addDataItem(series2, netherlands, 11486000);
        addDataItem(series2, sweden, 7480395);
        addDataItem(series2, unitedKingdom, 52372000);
        series3.setName("1970");
        addDataItem(series3, belgium, 9637800);
        addDataItem(series3, france, 51918000);
        addDataItem(series3, germany, 77783164);
        addDataItem(series3, netherlands, 13032335);
        addDataItem(series3, sweden, 8042803);
        addDataItem(series3, unitedKingdom, 55632000);

        Scene scene = new Scene(stackedBarChart, 800, 600);
        stackedBarChart.getData().addAll(series1, series2, series3);
        stage.setScene(scene);
        stage.show();
    }

    public void pieChartSample(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Europian Country Population");
        stage.setWidth(500);
        stage.setHeight(500);

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Belgium", 3),
                        new PieChart.Data("France", 26),
                        new PieChart.Data("Germany", 35),
                        new PieChart.Data("Netherlands", 7),
                        new PieChart.Data("Sweden", 4),
                        new PieChart.Data("United Kingdom", 25));

        final PieChart pieChart = new PieChart(pieChartData);
        pieChart.setTitle("Country Population");
        ((Group) scene.getRoot()).getChildren().add(pieChart);
        stage.setScene(scene);
        stage.show();
    }

    public void sampleScatterChart(Stage stage) {
        stage.setTitle("Scatter Chart Sample");
        final NumberAxis yAxis = new NumberAxis(1400, 2100, 100);
        final NumberAxis xAxis = new NumberAxis(500000, 90000000,
                1000000);
        final ScatterChart<Number, Number> scatterChart = new
                ScatterChart<>(xAxis, yAxis);

        xAxis.setLabel("Something");
        yAxis.setLabel("Decade");
        scatterChart.setTitle("Something Scatter Graph");

        XYChart.Series series = new XYChart.Series();

        addDataItem(series,600000, 1600);
        addDataItem(series,10000000, 1700);
        addDataItem(series,25000000, 1800);
        addDataItem(series,50000000, 1900);
        addDataItem(series,85000000, 2000);

        scatterChart.getData().addAll(series);

        Scene scene = new Scene(scatterChart, 500, 400);
        stage.setScene(scene);
        stage.show();
    }

    public void histogramSample(Stage stage) {
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();

        String[] gr = {"-4","-3","-2","-1","0","1","2","3","4"};
        int[] count = new int[9];
        for(int i = 0; i < 9; i++) count[i] = 0;

        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            Double r = random.nextGaussian();
            //System.out.println(r);
            if(r < -4) count[0]++;
            else if(r < -3) count[1]++;
            else if(r < -2) count[2]++;
            else if(r < -1) count[3]++;
            else if(r < 0) count[4]++;
            else if(r < 1) count[5]++;
            else if(r < 2) count[6]++;
            else if(r < 3) count[7]++;
            else count[8]++;
        }

        series1.setName("random.nextGaussian()");
        for(int i = 0; i<9; i++){
            addDataItem(series1, gr[i], count[i]);
        }

        stage.setTitle("Histogram Example");
        final BarChart<String, Number> barChart
                = new BarChart<>(xAxis, yAxis);
        barChart.setTitle("Histogram");
        xAxis.setLabel("Value");
        yAxis.setLabel("Amount");

        Scene scene = new Scene(barChart, 800, 600);
        barChart.getData().addAll(series1);
        stage.setScene(scene);
        stage.show();
    }

    public void addDataItem(XYChart.Series<String, Number> series,
                            String x, Number y) {
        series.getData().add(new XYChart.Data<>(x, y));
    }

    public void addDataItem(XYChart.Series<Number, Number> series,
                            Number x, Number y) {
        series.getData().add(new XYChart.Data<>(x, y));
    }
}

