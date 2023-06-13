import 'package:agendamento/Conferir.dart';
import 'package:agendamento/login.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'Cadastro.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: HomePage(),
      initialRoute: '/',
      routes: {
        '/HomePage': (context) => HomePage(),
        '/CadastroPage': (context) => CadastroPage(),
        '/loginPage': (context) => LoginPage(),
        '/PerfilPage': (context) => LoginPage(),
        '/conferirPage': (context) => ConferirPage(),
      },
    );
  }
}

class HomePage extends StatefulWidget {
  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  final GlobalKey<FormState> formKey = GlobalKey<FormState>();
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          backgroundColor: Color.fromRGBO(0, 0, 255, 0.54),
          toolbarHeight: 110,
          title: Image.asset(
            'assets/logo.png',
            fit: BoxFit.contain,
            height: 170,
          ),
          centerTitle: true,
        ),
        body: Center(
            child: Stack(
          children: [
            Column(
              mainAxisAlignment: MainAxisAlignment.spaceEvenly,
              children: [
                Padding(
                  padding: const EdgeInsets.all(16),
                  child: Form(
                    key: formKey,
                    child: Center(
                      child: ListView(
                        shrinkWrap: true,
                        children: [
                          TextFormField(
                              decoration: const InputDecoration(
                                labelText: 'Email',
                                labelStyle: TextStyle(
                                    color: Color.fromRGBO(0, 0, 255, 0.54),
                                    fontSize: 20),
                                hintText: 'Insira seu Email',
                                hintStyle: TextStyle(
                                  color: Color.fromRGBO(0, 0, 255, 0.54),
                                ),
                                suffixText: '@hotmail',
                                counterText: '',
                                border: OutlineInputBorder(),
                              ),
                              maxLength: 20,
                              keyboardType: TextInputType.text,
                              validator: (text) {
                                if (text == null || text.isEmpty)
                                  return 'Campo obrigatório';
                              }),
                          const SizedBox(height: 16),
                          TextFormField(
                            decoration: const InputDecoration(
                                labelText: 'Senha',
                                labelStyle: TextStyle(
                                  color: Color.fromRGBO(0, 0, 255, 0.54),
                                ),
                                hintText: 'Insira sua senha',
                                hintStyle: TextStyle(
                                  color: Color.fromRGBO(0, 0, 255, 0.54),
                                ),
                                suffixText: 'Senha',
                                counterText: '',
                                border: OutlineInputBorder()),
                            maxLength: 20,
                            keyboardType: TextInputType.number,
                            validator: (text) {
                              if (text == null || text.isEmpty)
                                return 'Campo obrigatório';
                            },
                          ),
                          Padding(
                            padding: const EdgeInsets.fromLTRB(
                                128.0, 8.0, 128.0, 8.0),
                            child: ElevatedButton(
                              style: ElevatedButton.styleFrom(
                                primary: Color.fromRGBO(0, 0, 255, 0.54),
                              ),
                              onPressed: () {
                                if (formKey.currentState!.validate()) {
                                  setState(() {
                                    Navigator.push(
                                      context,
                                      MaterialPageRoute(
                                        builder: (context) {
                                          return LoginPage();
                                        },
                                      ),
                                    );
                                  });
                                }
                              },
                              child: Text(
                                'Entrar',
                                style: TextStyle(
                                    color: Colors.white, fontSize: 20),
                              ),
                            ),
                          ),
                          Padding(
                            padding: const EdgeInsets.fromLTRB(
                                128.0, 8.0, 128.0, 8.0),
                            child: ElevatedButton(
                              style: ElevatedButton.styleFrom(
                                primary: const Color.fromRGBO(0, 0, 255, 0.54),
                              ),
                              onPressed: () {
                                Navigator.push(
                                  context,
                                  MaterialPageRoute(
                                    builder: (context) {
                                      return CadastroPage();
                                    },
                                  ),
                                );
                              },
                              child: Text(
                                'Cadastrar',
                                style: TextStyle(
                                    color: Colors.white, fontSize: 20),
                              ),
                            ),
                          )
                        ],
                      ),
                    ),
                  ),
                ),
              ],
            ),
          ],
        )));
  }
}
