package mx.brennen.sherlock.res;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

import mx.brennen.sherlock.R;


public class TableDynamic {

    private TableLayout tableLayout;
    private Context context;
    private CharSequence[] header;
    private ArrayList<String[]> data;
    private TableRow tableRow;
    private TextView txtCell;
    private int indexC;
    private int indexR;
    private int color;

    public TableDynamic(TableLayout tableLayout,Context context, Integer Color) {

        this.tableLayout = tableLayout;
        this.context = context;
        this.color = Color;

    }

    public  void addHeader(CharSequence[] header){

        this.header = header;
        createHeader();

    }

    public  void addData(ArrayList<String[]> data){

        this.data = data;
        createDataTable();

    }

    private void newRow(){

        tableRow = new TableRow(context);

    }

    private void newCell(){

        txtCell = new TextView(context);
        txtCell.setGravity(Gravity.CENTER);
        txtCell.setTextSize(25);

    }

    private void  createHeader(){

        indexC = 0;
        newRow();
        while (indexC<header.length){

            newCell();
            txtCell.setText(header[indexC++]);
            txtCell.setBackgroundColor(Color.parseColor("#ffffff"));
            txtCell.setTextSize(1,10f);
            txtCell.setTextColor(Color.parseColor("#C81E0A"));
            txtCell.setTypeface(Typeface.createFromAsset(context.getAssets(),"fonts/arciform.otf"));
            txtCell.setBackground(context.getDrawable(R.drawable.cellrectangle));
            txtCell.setPadding(0,10,0,15);
            tableRow.addView(txtCell,newTableRow());

        }

        tableLayout.addView(tableRow);

    }

    private void createDataTable(){

        String info;
        for (indexR = 1; indexR <= data.size(); indexR++) {

            newRow();

            for (indexC = 0; indexC < header.length; indexC++) {

                newCell();
                String[] Colums = data.get(indexR-1);
                info = (indexC<Colums.length)?Colums[indexC]:"";
                txtCell.setText(info);
                txtCell.setTextColor(Color.parseColor("#000000"));
                txtCell.setTextSize(1,10f);
                txtCell.setTypeface(Typeface.createFromAsset(context.getAssets(),"fonts/arciform.otf"));
                txtCell.setBackgroundColor(Color.parseColor("#ffffff"));
                txtCell.setBackground(context.getDrawable(R.drawable.cellrectangle));
                txtCell.setPadding(0,10,0,10);
                tableRow.addView(txtCell,newTableRow());

            }

            tableLayout.addView(tableRow);

        }

    }

    private TableRow.LayoutParams newTableRow(){

        TableRow.LayoutParams params = new TableRow.LayoutParams();
        params.setMargins(0,0,0,0);
        params.weight = 1;
        return params;

    }

}
