#include <Servo.h>

Servo servomotor; // falta el punto y coma

void setup()
{
  Serial.begin(9600);
  servomotor.attach(9);
}

void loop() // falta el nombre de la funcion
{
  for (int i = 0; i <= 180; i++)
  {
    servomotor.write(i);
    delay(25); // el parentesis inicial y pasar el numerito
    //            para definir el tiempo a esperar
  } // falta cerrar la llavecita

  for (int i = 179; i > 0; i--)
  {
    servomotor.write(i);
    delay(25);
  }
}