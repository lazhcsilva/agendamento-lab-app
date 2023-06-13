import 'package:agendamento/login.dart';
import 'package:agendamento/main.dart';
import 'package:flutter/material.dart';

class ConferirPage extends StatefulWidget {
  @override
  _ConferirPageState createState() => _ConferirPageState();
}

class _ConferirPageState extends State<ConferirPage> {
  final GlobalKey<FormState> formKey = GlobalKey<FormState>();
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Meus Agendamentos'),
        backgroundColor: Color.fromRGBO(0, 0, 255, 0.54),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Container(
              decoration: BoxDecoration(
                border: Border.all(
                  color: Color.fromRGBO(0, 0, 255, 0.54),
                  width: 2.0,
                ),
                borderRadius: BorderRadius.circular(8.0),
              ),
              child: Text(
                'Data:',
                style: TextStyle(
                    color: Color.fromRGBO(0, 0, 255, 0.54), fontSize: 20),
              ),
            ),
            SizedBox(height: 10),
            Container(
              child: Text(
                '20/06/2023',
                style: TextStyle(
                    color: Color.fromRGBO(0, 0, 255, 0.54), fontSize: 20),
              ),
            ),
            SizedBox(height: 10),
            Container(
              decoration: BoxDecoration(
                border: Border.all(
                  color: Color.fromRGBO(0, 0, 255, 0.54),
                  width: 2.0,
                ),
                borderRadius: BorderRadius.circular(8.0),
              ),
              child: Text(
                'Turno:',
                style: TextStyle(
                    color: Color.fromRGBO(0, 0, 255, 0.54), fontSize: 20),
              ),
            ),
            SizedBox(height: 10),
            Container(
              child: Text(
                'Noite (18h-20h)',
                style: TextStyle(
                    color: Color.fromRGBO(0, 0, 255, 0.54), fontSize: 20),
              ),
            ),
            SizedBox(height: 10),
            Container(
              decoration: BoxDecoration(
                border: Border.all(
                  color: Color.fromRGBO(0, 0, 255, 0.54),
                  width: 2.0,
                ),
                borderRadius: BorderRadius.circular(8.0),
              ),
              child: Text(
                'Disciplina:',
                style: TextStyle(
                    color: Color.fromRGBO(0, 0, 255, 0.54), fontSize: 20),
              ),
            ),
            SizedBox(height: 10),
            Container(
              child: Text(
                'Prática Profissional',
                style: TextStyle(
                    color: Color.fromRGBO(0, 0, 255, 0.54), fontSize: 20),
              ),
            ),
            SizedBox(height: 60),
            Container(
              decoration: BoxDecoration(
                border: Border.all(
                  color: Color.fromRGBO(0, 0, 255, 0.54),
                  width: 2.0,
                ),
                borderRadius: BorderRadius.circular(8.0),
              ),
              child: Text(
                'Data:',
                style: TextStyle(
                    color: Color.fromRGBO(0, 0, 255, 0.54), fontSize: 20),
              ),
            ),
            SizedBox(height: 10),
            Container(
              child: Text(
                '21/06/2023',
                style: TextStyle(
                    color: Color.fromRGBO(0, 0, 255, 0.54), fontSize: 20),
              ),
            ),
            SizedBox(height: 10),
            Container(
              decoration: BoxDecoration(
                border: Border.all(
                  color: Color.fromRGBO(0, 0, 255, 0.54),
                  width: 2.0,
                ),
                borderRadius: BorderRadius.circular(8.0),
              ),
              child: Text(
                'Turno:',
                style: TextStyle(
                    color: Color.fromRGBO(0, 0, 255, 0.54), fontSize: 20),
              ),
            ),
            SizedBox(height: 10),
            Container(
              child: Text(
                'Noite (18h-20h)',
                style: TextStyle(
                    color: Color.fromRGBO(0, 0, 255, 0.54), fontSize: 20),
              ),
            ),
            SizedBox(height: 10),
            Container(
              decoration: BoxDecoration(
                border: Border.all(
                  color: Color.fromRGBO(0, 0, 255, 0.54),
                  width: 2.0,
                ),
                borderRadius: BorderRadius.circular(8.0),
              ),
              child: Text(
                'Disciplina:',
                style: TextStyle(
                    color: Color.fromRGBO(0, 0, 255, 0.54), fontSize: 20),
              ),
            ),
            SizedBox(height: 10),
            Container(
              child: Text(
                'Prática Profissional',
                style: TextStyle(
                    color: Color.fromRGBO(0, 0, 255, 0.54), fontSize: 20),
              ),
            ),
            SizedBox(height: 30),
            ElevatedButton(
              style: ElevatedButton.styleFrom(
                primary: Color.fromRGBO(0, 0, 255, 0.54),
              ),
              onPressed: () {
                Navigator.pop(
                  context,
                  MaterialPageRoute(
                    builder: (context) {
                      return LoginPage();
                    },
                  ),
                );
              },
              child: Text('Voltar'),
            ),
          ],
        ),
      ),
    );
  }
}
