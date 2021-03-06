package com.example.inventory.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.inventory.R;
import com.example.inventory.pojo.Dependency;
import com.example.inventory.DependencyRepository;
import com.github.ivbaranov.mli.MaterialLetterIcon;

/**
 * Created by usuario on 26/10/17.
 */

public class DependencyAdapterA extends ArrayAdapter<Dependency> {
    public DependencyAdapterA(@NonNull Context context) {
        super(context, R.layout.item_dependency, DependencyRepository.getInstance().getDependencies());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        MaterialLetterIcon icon;
        TextView txvName;
        TextView txvShortName;
        View view;

        //Obtener el servicio inflater desde el contexto
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //Inflamos la vista.
        view = inflater.inflate(R.layout.item_dependency, null);

        //3 Asignamos los elementos de la vista. Cuidado,view.findIdView
        icon = (MaterialLetterIcon) view.findViewById(R.id.icon);
        txvName = (TextView) view.findViewById(R.id.txvPrimary);
        txvShortName = (TextView) view.findViewById(R.id.txvSecondary);

        //4. Mostramos los datos del ArrayList mediandte posicion
        icon.setLetter(getItem(position).getShortname().substring(0, 1));
        txvName.setText(getItem(position).getName());
        txvShortName.setText(getItem(position).getShortname());
        return view;
    }
}
