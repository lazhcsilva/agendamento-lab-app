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
      initialRoute: '/HomePage',
      routes: {
        '/HomePage': (context) => HomePage(),
        '/primeira': (context) => Cadastro(),
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
          backgroundColor: Colors.purple,
          toolbarHeight: 110,
          title: Text(
            'Uninassau',
            style: TextStyle(
              fontFamily: 'Anton',
              color: Colors.white,
            ),
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
                                    color: Colors.purple, fontSize: 20),
                                hintText: 'Insira seu Email',
                                hintStyle: TextStyle(color: Colors.purple),
                                suffixText: '@hotmail',
                                counterText: '',
                                border: OutlineInputBorder(),
                              ),
                              maxLength: 4,
                              keyboardType: TextInputType.text,
                              validator: (text) {
                                if (text == null || text.isEmpty)
                                  return 'Campo obrigatório';
                              }),
                          const SizedBox(height: 16),
                          TextFormField(
                            decoration: const InputDecoration(
                                labelText: 'Senha',
                                labelStyle: TextStyle(color: Colors.purple),
                                hintText: 'Insira sua senha',
                                hintStyle: TextStyle(color: Colors.purple),
                                suffixText: 'Senha',
                                counterText: '',
                                border: OutlineInputBorder()),
                            maxLength: 4,
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
                                  primary: Colors.purple),
                              onPressed: () {
                                if (formKey.currentState!.validate()) {
                                  setState(() {});
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
                                  primary:
                                      const Color.fromRGBO(156, 39, 176, 1)),
                              onPressed: () {
                                Navigator.push(
                                  context,
                                  MaterialPageRoute(
                                    builder: (context) {
                                      return Cadastro();
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
