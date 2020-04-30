package com.chinalwb.are.demo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.chinalwb.are.demo.R;

import java.util.zip.Inflater;

public class DialogSave extends AppCompatDialogFragment {
    private EditText editTextFilename;
    private SaveDialogListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.save_dialog, null);


        builder.setView(view)
                .setTitle("Save file")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String filename = editTextFilename.getText().toString();
                        listener.applyText(filename);
                    }
                });
        editTextFilename = view.findViewById(R.id.edit_filename);
        editTextFilename.setText(getTag());
        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (SaveDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement SaveDialogListener");
        }
    }

    public interface SaveDialogListener{
        void applyText(String filename);
    }
}
