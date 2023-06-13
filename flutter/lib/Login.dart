import 'dart:convert';

import 'package:agendamento/Agendamento.dart';
import 'package:agendamento/Conferir.dart';
import 'package:agendamento/Perfil.dart';
import 'package:agendamento/main.dart';
import 'package:flutter/material.dart';

class LoginPage extends StatefulWidget {
  @override
  _LoginPageState createState() => _LoginPageState();
}

class _LoginPageState extends State<LoginPage> {
  final GlobalKey<FormState> formKey = GlobalKey<FormState>();
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Color.fromRGBO(0, 0, 255, 0.54),
        title: Text('Olá, Lucas'),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Icon(
              Icons.account_circle,
              size: 100,
              color: Color.fromRGBO(0, 0, 255, 0.54),
            ),
            SizedBox(height: 20),
            ElevatedButton(
              style: ElevatedButton.styleFrom(
                primary: Color.fromRGBO(0, 0, 255, 0.54),
              ),
              onPressed: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(
                    builder: (context) {
                      return AgendamentoPage();
                    },
                  ),
                );
              },
              child: Text('Novo Agendamento'),
            ),
            SizedBox(height: 10),
            ElevatedButton(
              style: ElevatedButton.styleFrom(
                primary: Color.fromRGBO(0, 0, 255, 0.54),
              ),
              onPressed: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(
                    builder: (context) {
                      return PerfilPage();
                    },
                  ),
                );
              },
              child: Text('Meu Perfil'),
            ),
            SizedBox(height: 10),
            ElevatedButton(
              style: ElevatedButton.styleFrom(
                primary: Color.fromRGBO(0, 0, 255, 0.54),
              ),
              onPressed: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(
                    builder: (context) {
                      return ConferirPage();
                    },
                  ),
                );
              },
              child: Text('Meus Agendamentos'),
            ),
          ],
        ),
      ),
    );
  }
}
