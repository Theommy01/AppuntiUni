import 'package:flutter/material.dart';

class AboutUs extends StatefulWidget {
  const AboutUs({super.key});
  @override
  State<AboutUs> createState() => _AboutUsState();
}

class _AboutUsState extends State<AboutUs> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Color.fromRGBO(203, 235, 236, 1.0),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Text(
              'SkiTracker',
              style: TextStyle(fontSize: 50),
            ),

            SizedBox(height: 35),

            Image.asset(
              'assets/images/icona_progetto.png', //indirizzo
              width: 320, //lunghezza
              height: 100, //altezza
            ),

            SizedBox(height: 35), // margine verticale in basso

            Padding(
                padding: EdgeInsets.only(left: 20, right: 20),
                child: Text('Sviluppatori: Arduini Federico, Naja Omar',
                    style: TextStyle(fontSize: 20),
                    textAlign: TextAlign.center)),

            SizedBox(height: 8),

            Text(
              'Versione: 1.0',
              style: TextStyle(fontSize: 20),
            ),
          ],
        ),
      ),
    );
  }
}
