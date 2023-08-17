import 'package:flutter/material.dart';

class ZoomRegulationDialog extends StatefulWidget {
  @override
  _ZoomRegulationDialogState createState() => _ZoomRegulationDialogState();
}

class _ZoomRegulationDialogState extends State<ZoomRegulationDialog> {
  int selectedValue = 0;

  @override
  Widget build(BuildContext context) {
    return AlertDialog(
      title: Text('Che succede?'),
      content: Column(
        mainAxisSize: MainAxisSize.min,
        children: [
          ListTile(
            title: Text('Non vedo alcune piste'),
            leading: Radio(
              value: 0,
              groupValue: selectedValue,
              onChanged: (value) {
                setState(() {
                  selectedValue = value as int;
                });
              },
            ),
          ),
          ListTile(
            title: Text('Vedo troppe piste'),
            leading: Radio(
              value: 1,
              groupValue: selectedValue,
              onChanged: (value) {
                setState(() {
                  selectedValue = value as int;
                });
              },
            ),
          ),
        ],
      ),
      actions: [
        TextButton(
          onPressed: () {
            Navigator.pop(context, selectedValue); // Chiudi il dialog e restituisci il valore selezionato
          },
          child: Text('Conferma'),
        ),
      ],
    );
  }
}
