import 'dart:convert';

import 'package:agendamento/main.dart';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:http/http.dart';
import 'package:flutter/services.dart';

class CadastroPage extends StatefulWidget {
  @override
  _CadastroPageState createState() => _CadastroPageState();
}

class _CadastroPageState extends State<CadastroPage> {
  final GlobalKey<FormState> formKey = GlobalKey<FormState>();
  final TextEditingController _Nome = TextEditingController();
  final TextEditingController _Senha = TextEditingController();
  final TextEditingController _Senha2 = TextEditingController();
  final TextEditingController _Cadeira = TextEditingController();
  final TextEditingController _Email = TextEditingController();
  Future<void> registerUser() async {
    final url = Uri.https("http://localhost:8080/api/v1/cadfunc");

    final data = {
      "nome": _Nome.text,
      "senha": _Senha.text,
      "email": _Email.text,
      "cadeira": _Cadeira.text
    };

    final body = jsonEncode(data);

    final response = await http.post(url, body: body);
    if (response.statusCode == 200) {
      var responseData = jsonDecode(response.body);
      print(responseData);
    } else {
      // Erro
      print('Erro na solicitação POST: ${response.statusCode}');
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          backgroundColor: Color.fromRGBO(0, 0, 255, 0.54),
          toolbarHeight: 110,
          title: Text(
            'Cadastro',
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
            SingleChildScrollView(
              child: Column(
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
                            Text('Nome'),
                            TextFormField(
                                decoration: const InputDecoration(
                                  hintText: 'Insira seu nome',
                                  hintStyle: TextStyle(
                                    color: Color.fromRGBO(0, 0, 255, 0.54),
                                  ),
                                  counterText: '',
                                  border: OutlineInputBorder(),
                                ),
                                controller: _Nome,
                                maxLength: 20,
                                keyboardType: TextInputType.text,
                                validator: (text) {
                                  if (text == null || text.isEmpty)
                                    return 'Campo obrigatório';
                                }),
                            const SizedBox(height: 16),
                            Text("E-mail"),
                            TextFormField(
                              decoration: const InputDecoration(
                                  hintText: 'Insira seu e-mail',
                                  hintStyle: TextStyle(
                                    color: Color.fromRGBO(0, 0, 255, 0.54),
                                  ),
                                  suffixText: 'e-mail',
                                  counterText: '',
                                  border: OutlineInputBorder()),
                              controller: _Email,
                              maxLength: 20,
                              keyboardType: TextInputType.text,
                              validator: (text) {
                                if (text == null || text.isEmpty)
                                  return 'Campo obrigatório';
                              },
                            ),
                            const SizedBox(height: 16),
                            Text('Senha'),
                            TextFormField(
                              decoration: const InputDecoration(
                                  hintText: 'Insira sua senha',
                                  hintStyle: TextStyle(
                                    color: Color.fromRGBO(0, 0, 255, 0.54),
                                  ),
                                  suffixText: 'Senha',
                                  counterText: '',
                                  border: OutlineInputBorder()),
                              controller: _Senha,
                              maxLength: 20,
                              keyboardType: TextInputType.number,
                              validator: (text1) {
                                if (text1 == null || text1.isEmpty)
                                  return 'Campo obrigatório';
                              },
                            ),
                            const SizedBox(height: 16),
                            Text('Senha Novamente'),
                            TextFormField(
                              decoration: const InputDecoration(
                                  hintText: 'Insira sua senha',
                                  hintStyle: TextStyle(
                                    color: Color.fromRGBO(0, 0, 255, 0.54),
                                  ),
                                  suffixText: 'Senha',
                                  counterText: '',
                                  border: OutlineInputBorder()),
                              controller: _Senha2,
                              maxLength: 20,
                              keyboardType: TextInputType.number,
                              validator: (text2) {
                                if (text2 == null ||
                                    text2.isEmpty ||
                                    _Senha.text != _Senha2.text)
                                  return 'senhas estão diferentes';
                              },
                            ),
                            const SizedBox(height: 16),
                            Text('Disciplina'),
                            TextFormField(
                              decoration: const InputDecoration(
                                  hintText: 'Insira sua Cadeira',
                                  hintStyle: TextStyle(
                                    color: Color.fromRGBO(0, 0, 255, 0.54),
                                  ),
                                  suffixText: 'Disciplina',
                                  counterText: '',
                                  border: OutlineInputBorder()),
                              controller: _Cadeira,
                              maxLength: 20,
                              keyboardType: TextInputType.text,
                              validator: (text) {
                                if (text == null || text.isEmpty)
                                  return 'Campo obrigatório';
                              },
                            ),
                            const SizedBox(height: 16),
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
                                      final String nome = _Nome.text;
                                      final String senha = _Senha.text;

                                      final String Cadeira = _Cadeira.text;
                                      final String email = _Email.text;
                                      Navigator.pop(
                                        context,
                                        MaterialPageRoute(
                                          builder: (context) {
                                            return HomePage();
                                          },
                                        ),
                                      );
                                    });
                                    registerUser();
                                  }
                                },
                                child: Text(
                                  'Cadastrar',
                                  style: TextStyle(
                                      color: Colors.white, fontSize: 20),
                                ),
                              ),
                            ),
                          ],
                        ),
                      ),
                    ),
                  ),
                ],
              ),
            ),
          ],
        )));
  }
}
