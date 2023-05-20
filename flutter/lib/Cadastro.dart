import 'package:agendamento/main.dart';
import 'package:flutter/material.dart';

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
  final TextEditingController _Matricula = TextEditingController();
  final TextEditingController _Disciplina = TextEditingController();
  final TextEditingController _Email = TextEditingController();

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
                          Text('Nome'),
                          TextFormField(
                              decoration: const InputDecoration(
                                labelText: 'insira seu nome completo',
                                labelStyle: TextStyle(
                                    color: Colors.purple, fontSize: 20),
                                hintText: 'Insira seu nome',
                                hintStyle: TextStyle(color: Colors.purple),
                                counterText: '',
                                border: OutlineInputBorder(),
                              ),
                              controller: _Nome,
                              maxLength: 10,
                              keyboardType: TextInputType.text,
                              validator: (text) {
                                if (text == null || text.isEmpty)
                                  return 'Campo obrigatório';
                              }),
                          const SizedBox(
                            height: 16,
                          ),
                          Text("Matrícula"),
                          TextFormField(
                            decoration: const InputDecoration(
                                labelText: 'Insira sua Matrícula',
                                labelStyle: TextStyle(color: Colors.purple),
                                hintText: 'Insira sua Matrícula',
                                hintStyle: TextStyle(color: Colors.purple),
                                suffixText: 'Matrícula',
                                counterText: '',
                                border: OutlineInputBorder()),
                            controller: _Matricula,
                            maxLength: 10,
                            keyboardType: TextInputType.number,
                            validator: (text) {
                              if (text == null || text.isEmpty)
                                return 'Campo obrigatório';
                            },
                          ),
                          const SizedBox(height: 16),
                          Text("E-mail"),
                          TextFormField(
                            decoration: const InputDecoration(
                                labelText: 'Insira seu e-mail',
                                labelStyle: TextStyle(color: Colors.purple),
                                hintText: 'Insira seu e-mail',
                                hintStyle: TextStyle(color: Colors.purple),
                                suffixText: 'e-mail',
                                counterText: '',
                                border: OutlineInputBorder()),
                            controller: _Email,
                            maxLength: 10,
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
                                labelText: 'Insira sua senha',
                                labelStyle: TextStyle(color: Colors.purple),
                                hintText: 'Insira sua senha',
                                hintStyle: TextStyle(color: Colors.purple),
                                suffixText: 'Senha',
                                counterText: '',
                                border: OutlineInputBorder()),
                            controller: _Senha,
                            maxLength: 10,
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
                                labelText: 'Insira sua senha novamente',
                                labelStyle: TextStyle(color: Colors.purple),
                                hintText: 'Insira sua senha',
                                hintStyle: TextStyle(color: Colors.purple),
                                suffixText: 'Senha',
                                counterText: '',
                                border: OutlineInputBorder()),
                            controller: _Senha2,
                            maxLength: 10,
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
                                labelText: 'Insira sua Disciplina',
                                labelStyle: TextStyle(color: Colors.purple),
                                hintText: 'Insira sua Disciplina',
                                hintStyle: TextStyle(color: Colors.purple),
                                suffixText: 'Disciplina',
                                counterText: '',
                                border: OutlineInputBorder()),
                            controller: _Disciplina,
                            maxLength: 10,
                            keyboardType: TextInputType.number,
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
                                  primary: Colors.purple),
                              onPressed: () {
                                if (formKey.currentState!.validate()) {
                                  setState(() {
                                    final String nome = _Nome.text;
                                    final double? senha =
                                        double.tryParse(_Senha.text);
                                    final double? matricula =
                                        double.tryParse(_Matricula.text);
                                    final String disciplina = _Disciplina.text;
                                    final String email = _Email.text;
                                    Navigator.push(
                                      context,
                                      MaterialPageRoute(
                                        builder: (context) {
                                          return HomePage();
                                        },
                                      ),
                                    );
                                  });
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
          ],
        )));
  }
}
