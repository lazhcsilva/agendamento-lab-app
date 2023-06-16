import 'package:agendamento/login.dart';
import 'package:flutter/material.dart';

class AgendamentoPage extends StatefulWidget {
  @override
  _AgendamentoPageState createState() => _AgendamentoPageState();
}

class _AgendamentoPageState extends State<AgendamentoPage> {
  final GlobalKey<FormState> formKey = GlobalKey<FormState>();

  final TextEditingController _selectedDate = TextEditingController();
  final TextEditingController _selectedTurn = TextEditingController();
  final TextEditingController _discipline = TextEditingController();

  List<String> turnOptions = [
    'Manhã (8h-12h)',
    'Tarde (13h-17h)',
    'Noite (18h-22h)'
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Color.fromRGBO(0, 0, 255, 0.54),
        title: Text('Agendamento'),
      ),
      body: Center(
        child: Padding(
          padding: EdgeInsets.all(20),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              TextField(
                decoration: InputDecoration(
                  labelText: 'Digite uma data',
                  border: OutlineInputBorder(),
                ),
                controller: _selectedDate,
                onChanged: (value) {
                  // Lógica para lidar com a data digitada
                },
              ),
              SizedBox(height: 20),
              Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: turnOptions.map((turn) {
                  return Row(
                    children: [
                      Checkbox(
                        value: _selectedTurn == turn,
                        onChanged: (value) {
                          setState(() {});
                        },
                      ),
                      Text(turn),
                    ],
                  );
                }).toList(),
              ),
              SizedBox(height: 20),
              TextField(
                decoration: InputDecoration(
                  labelText: 'Digite a disciplina',
                  border: OutlineInputBorder(),
                ),
                controller: _discipline,
                onChanged: (value) {
                  setState(() {});
                },
              ),
              SizedBox(height: 20),
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
                child: Text('Confirmar Agendamento'),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
