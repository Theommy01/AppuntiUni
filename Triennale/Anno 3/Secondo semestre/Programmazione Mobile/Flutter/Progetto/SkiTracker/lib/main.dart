import 'package:flutter/material.dart';
import 'package:SkiTracker/about_us.dart';
import 'package:SkiTracker/mappa.dart';
import 'package:flutter/services.dart';
import 'info_piste.dart';

Future<void> main() async {
  WidgetsFlutterBinding.ensureInitialized();
  await SystemChrome.setPreferredOrientations([
    DeviceOrientation.portraitUp,
  ]);
  runApp(new MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'SkiTracker',
      theme: ThemeData(
        // This is the theme of your application.
        //
        // TRY THIS: Try running your application with "flutter run". You'll see
        // the application has a blue toolbar. Then, without quitting the app,
        // try changing the seedColor in the colorScheme below to Colors.green
        // and then invoke "hot reload" (save your changes or press the "hot
        // reload" button in a Flutter-supported IDE, or press "r" if you used
        // the command line to start the app).
        //
        // Notice that the counter didn't reset back to zero; the application
        // state is not lost during the reload. To reset the state, use hot
        // restart instead.
        //
        // This works for code too, not just values: Most code changes can be
        // tested with just a hot reload.
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.lightBlue),
        useMaterial3: true,
      ),
      home: MyHomePage(title: 'SkiTracker', subtitle: 'Comprensorio: <nome_comprensorio>'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  MyHomePage({super.key, required this.title, required this.subtitle});

  final String title;
  final String subtitle;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  final Color titleColor = Colors.white;

  int _currentIndex = 0;
  final screens = [
    Mappa(),
    InfoPiste(),
    AboutUs(),
  ];

  @override
  Widget build(BuildContext context) {
    // This method is rerun every time setState is called, for instance as done
    // by the _incrementCounter method above.
    //
    // The Flutter framework has been optimized to make rerunning build methods
    // fast, so that you can just rebuild anything that needs updating rather
    // than having to individually change instances of widgets.
    return Scaffold(
      backgroundColor: Color.fromRGBO(203, 235, 236, 1.0),

      appBar: AppBar(

        title: Text(
          widget.title,
          style: TextStyle(
            color: titleColor,
          ),
        ),
        //  centerTitle: true,
        backgroundColor: Color.fromRGBO(44, 124, 163, 1.0),

        elevation: 0.0,
      ),

      body: screens[_currentIndex],

      //Bottom Navigation Bar
      bottomNavigationBar: BottomNavigationBar(

        currentIndex: _currentIndex,
        onTap: (value) {
          setState(() {
            _currentIndex = value;
          });
        },

        backgroundColor: Colors.white,
        items: [
          BottomNavigationBarItem(
            icon: Icon(Icons.map),
            label: "Mappa",
            backgroundColor: Colors.lightBlue,
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.downhill_skiing),
            label: "Info comprensorio",
            backgroundColor: Colors.lightBlue,
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.info_outline_rounded),
            label: "About Us",
            backgroundColor: Colors.lightBlue,
          ),
        ],
      ),

    );
  }
}