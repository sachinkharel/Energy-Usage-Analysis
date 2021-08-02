import java.io.*;
import java.util.Calendar;
import org.apache.commons.csv.*;
import java.util.Arrays;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class energyAnalysis extends Application {
    public static void main(String[] args) throws IOException {
        launch(args);
    }

    public Integer[] maxVlaue(String filename) throws IOException {
        double max = 0;
        int date = 0;
        double total = 0;
        Reader fr = new FileReader(filename);
        for (CSVRecord record : CSVFormat.EXCEL.withFirstRecordAsHeader().parse(fr)) {
            for (int i = 1; i <= 48; i++) {
                double temp = Double.parseDouble(record.get(i));
                total += temp;
                if (temp > max) {
                    max = temp;
                    date = Integer.parseInt(record.get(0));
                }
            }
        }
        Integer[] values = new Integer[3];
        values[0] = (int) max;
        values[1] = date;
        values[2] = (int) total;
        return values;
    }

    public Double[] peakValues(String filename) throws IOException {
        System.out.println(filename);
        int day = 0;
        int month = 0;
        int year = 0;
        double sumPeak = 0;
        double janPeak = 0, febPeak = 0, marPeak = 0, aprPeak = 0, mayPeak = 0, junPeak = 0, julPeak = 0, augPeak = 0,
                sepPeak = 0, octPeak = 0, novPeak = 0, decPeak = 0;
        FileReader fr = new FileReader(filename);
        for (CSVRecord record : CSVFormat.EXCEL.withFirstRecordAsHeader().parse(fr)) {
            int dateInside = Integer.parseInt(record.get(0));
            day = dateInside % 100;
            month = ((dateInside % 10000) / 100);
            year = dateInside / 10000;
            Calendar c = Calendar.getInstance();
            c.set((year), (month) - 1, (day));
            int days = c.get(Calendar.DAY_OF_WEEK);
            if (days != 1 && days != 7) {
                for (int a = 19; a <= 43; a++) {
                    sumPeak += Double.parseDouble(record.get(a));
                    switch (month) {
                        case 1:
                            janPeak += Double.parseDouble(record.get(a));
                            break;
                        case 2:
                            febPeak += Double.parseDouble(record.get(a));
                            break;
                        case 3:
                            marPeak += Double.parseDouble(record.get(a));
                            break;
                        case 4:
                            aprPeak += Double.parseDouble(record.get(a));
                            break;
                        case 5:
                            mayPeak += Double.parseDouble(record.get(a));
                            break;
                        case 6:
                            junPeak += Double.parseDouble(record.get(a));
                            break;
                        case 7:
                            julPeak += Double.parseDouble(record.get(a));
                            break;
                        case 8:
                            augPeak += Double.parseDouble(record.get(a));
                            break;
                        case 9:
                            sepPeak += Double.parseDouble(record.get(a));
                            break;
                        case 10:
                            octPeak += Double.parseDouble(record.get(a));
                            break;
                        case 11:
                            novPeak += Double.parseDouble(record.get(a));
                            break;
                        case 12:
                            decPeak += Double.parseDouble(record.get(a));
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        Double[] peakMonths = new Double[12];
        peakMonths[0] = janPeak;
        peakMonths[1] = febPeak;
        peakMonths[2] = marPeak;
        peakMonths[3] = aprPeak;
        peakMonths[4] = mayPeak;
        peakMonths[5] = junPeak;
        peakMonths[6] = julPeak;
        peakMonths[7] = augPeak;
        peakMonths[8] = sepPeak;
        peakMonths[9] = octPeak;
        peakMonths[10] = novPeak;
        peakMonths[11] = decPeak;
        return peakMonths;
    }

    public Double[] offPeakValues(double janPeak, double febPeak, double marPeak, double aprPeak, double mayPeak,
            double junPeak, double julPeak, double augPeak, double sepPeak, double octPeak, double novPeak,
            double decPeak, String filename) throws IOException {
        int day = 0;
        int month = 0;
        int year = 0;
        double janTotal = 0, febTotal = 0, marTotal = 0, aprTotal = 0, mayTotal = 0, junTotal = 0, julTotal = 0,
                augTotal = 0, sepTotal = 0, octTotal = 0, novTotal = 0, decTotal = 0;
        double janOffPeak = 0, febOffPeak = 0, marOffPeak = 0, aprOffPeak = 0, mayOffPeak = 0, junOffPeak = 0,
                julOffPeak = 0, augOffPeak = 0, sepOffPeak = 0, octOffPeak = 0, novOffPeak = 0, decOffPeak = 0;
        Reader fr = new FileReader(filename);
        for (CSVRecord record : CSVFormat.EXCEL.withFirstRecordAsHeader().parse(fr)) {
            int dateInside = Integer.parseInt(record.get(0));
            day = dateInside % 100;
            month = ((dateInside % 10000) / 100);
            year = dateInside / 10000;
            Calendar c = Calendar.getInstance();
            c.set((year), (month) - 1, (day));
            int days = c.get(Calendar.DAY_OF_WEEK);
            for (int b = 1; b <= 48; b++) {
                switch (month) {
                    case 1:
                        janTotal += Double.parseDouble(record.get(b));
                        break;
                    case 2:
                        febTotal += Double.parseDouble(record.get(b));
                        break;
                    case 3:
                        marTotal += Double.parseDouble(record.get(b));
                        break;
                    case 4:
                        aprTotal += Double.parseDouble(record.get(b));
                        break;
                    case 5:
                        mayTotal += Double.parseDouble(record.get(b));
                        break;
                    case 6:
                        junTotal += Double.parseDouble(record.get(b));
                        break;
                    case 7:
                        julTotal += Double.parseDouble(record.get(b));
                        break;
                    case 8:
                        augTotal += Double.parseDouble(record.get(b));
                        break;
                    case 9:
                        sepTotal += Double.parseDouble(record.get(b));
                        break;
                    case 10:
                        octTotal += Double.parseDouble(record.get(b));
                        break;
                    case 11:
                        novTotal += Double.parseDouble(record.get(b));
                        break;
                    case 12:
                        decTotal += Double.parseDouble(record.get(b));
                        break;
                    default:
                        break;
                }
            }
        }
        janOffPeak = janTotal - janPeak;
        febOffPeak = febTotal - febPeak;
        marOffPeak = marTotal - marPeak;
        aprOffPeak = aprTotal - aprPeak;
        mayOffPeak = mayTotal - mayPeak;
        junOffPeak = junTotal - junPeak;
        julOffPeak = julTotal - julPeak;
        augOffPeak = augTotal - augPeak;
        sepOffPeak = sepTotal - sepPeak;
        octOffPeak = octTotal - octPeak;
        novOffPeak = novTotal - novPeak;
        decOffPeak = decTotal - decPeak;
        Double[] offPeakMonths = new Double[12];
        offPeakMonths[0] = janOffPeak;
        offPeakMonths[1] = febOffPeak;
        offPeakMonths[2] = marOffPeak;
        offPeakMonths[3] = aprOffPeak;
        offPeakMonths[4] = mayOffPeak;
        offPeakMonths[5] = junOffPeak;
        offPeakMonths[6] = julOffPeak;
        offPeakMonths[7] = augOffPeak;
        offPeakMonths[8] = sepOffPeak;
        offPeakMonths[9] = octOffPeak;
        offPeakMonths[10] = novOffPeak;
        offPeakMonths[11] = decOffPeak;
        return offPeakMonths;
    }

    final CategoryAxis xAxis = new CategoryAxis();
    final NumberAxis yAxis = new NumberAxis();
    final StackedBarChart<String, Number> sbc = new StackedBarChart<String, Number>(xAxis, yAxis);
    final XYChart.Series<String, Number> series1 = new XYChart.Series<String, Number>();
    final XYChart.Series<String, Number> series2 = new XYChart.Series<String, Number>();

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Bar Chart Sample");
        Label file = new Label("Enter Filename");
        file.setPadding(new Insets(10));
        TextField fileN = new TextField();
        fileN.setMaxWidth(150);
        Button confirm = new Button("Show Graph");
        confirm.setPadding(new Insets(10));
        confirm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                energyAnalysis get = new energyAnalysis();
                Double[] peakData = new Double[12];
                String nameOfFile = fileN.getText();
                Number[] maxValues = new Double[3];
                try {
                    peakData = get.peakValues(nameOfFile);
                    maxValues = get.maxVlaue(nameOfFile);
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                Double[] offPeakData = new Double[12];
                try {
                    offPeakData = get.offPeakValues(peakData[0], peakData[1], peakData[2], peakData[3], peakData[4],
                            peakData[5], peakData[6], peakData[7], peakData[8], peakData[9], peakData[10], peakData[11],
                            nameOfFile);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                String totalUsage = String.valueOf(maxValues[2]);

                sbc.setTitle("Total Usage " + totalUsage + " kWh");
                xAxis.setLabel("Months");
                xAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList("Jan", "Feb", "Mar", "Apr",
                        "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec")));
                yAxis.setLabel("kWh");
                series1.setName("Peak");
                series1.getData().add(new XYChart.Data<String, Number>("Jan", peakData[0]));
                series1.getData().add(new XYChart.Data<String, Number>("Feb", peakData[1]));
                series1.getData().add(new XYChart.Data<String, Number>("Mar", peakData[2]));
                series1.getData().add(new XYChart.Data<String, Number>("Apr", peakData[3]));
                series1.getData().add(new XYChart.Data<String, Number>("May", peakData[4]));
                series1.getData().add(new XYChart.Data<String, Number>("Jun", peakData[5]));
                series1.getData().add(new XYChart.Data<String, Number>("Jul", peakData[6]));
                series1.getData().add(new XYChart.Data<String, Number>("Aug", peakData[7]));
                series1.getData().add(new XYChart.Data<String, Number>("Sep", peakData[8]));
                series1.getData().add(new XYChart.Data<String, Number>("Oct", peakData[9]));
                series1.getData().add(new XYChart.Data<String, Number>("Nov", peakData[10]));
                series1.getData().add(new XYChart.Data<String, Number>("Dec", peakData[11]));
                series2.setName("OffPeak");
                series2.getData().add(new XYChart.Data<String, Number>("Jan", offPeakData[0]));
                series2.getData().add(new XYChart.Data<String, Number>("Feb", offPeakData[1]));
                series2.getData().add(new XYChart.Data<String, Number>("Mar", offPeakData[2]));
                series2.getData().add(new XYChart.Data<String, Number>("Apr", offPeakData[3]));
                series2.getData().add(new XYChart.Data<String, Number>("May", offPeakData[4]));
                series2.getData().add(new XYChart.Data<String, Number>("Jun", offPeakData[5]));
                series2.getData().add(new XYChart.Data<String, Number>("Jul", offPeakData[6]));
                series2.getData().add(new XYChart.Data<String, Number>("Aug", offPeakData[7]));
                series2.getData().add(new XYChart.Data<String, Number>("Sep", offPeakData[8]));
                series2.getData().add(new XYChart.Data<String, Number>("Oct", offPeakData[9]));
                series2.getData().add(new XYChart.Data<String, Number>("Nov", offPeakData[10]));
                series2.getData().add(new XYChart.Data<String, Number>("Dec", offPeakData[11]));

                sbc.setCategoryGap(20);
                Scene scene = new Scene(sbc, 800, 600);
                sbc.getData().addAll(series1, series2);
                stage.setScene(scene);
                stage.show();
            }

        });
        VBox root = new VBox();
        root.getChildren().addAll(file, fileN, confirm);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(0, 20, 0, 10));
        stage.setScene(new Scene(root, 800, 600));
        stage.centerOnScreen();
        stage.show();

    }
}
