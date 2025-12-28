clc
clear all

mi_Robot=legoev3('USB');


%% Definicion motor de la cabeza
motor_cabeza = motor(mi_Robot,'A');
start(motor_cabeza);

%% Necesario un reset
resetRotation(motor_cabeza)


Pulsador = touchSensor(mi_Robot, 2);
while(readTouch(Pulsador) == 0) 
    
    disp 'Esperando..'
    pause(0.2)
end

while(readTouch(Pulsador) == 1) 
    
end

tf = 10;
n = 1;
tstart = tic;
tiempo(n) = toc(tstart);
giro_Cabeza(1) = double(readRotation(motor_cabeza));
% ref con valor fijo
% valor_deseado = 90;
% ref(1) = valor_deseado;
ref(1) = tiempo(1)*200;
error(1) = ref(1) - giro_Cabeza(1);
I(n) = 0;
kp = 0.6;
ki = 0.05;
kd = 0.1; %!!!!!!!!!!!!!!!!!!!! DEFINIR EMPÍRICAMENTE!!!!!!!!!!!!!!!
while(readTouch(Pulsador) == 0)
    % lectura del tiempo
    tiempo(n) = toc(tstart);
    giro_Cabeza(n)=double(readRotation(motor_cabeza));
    ref(n) = tiempo(n)*200;

    % cálculo del error proporcional
    error(n)= ref(n)- giro_Cabeza(n);

    % cálculo del error integral
    dt = tiempo(n) - tiempo(n-1);
    I(n) = I(n-1) + error(n)*dt;

    % cálculo del error derivado
    D(n) = (error(n) - error(n-1))/dt

    %def controlador
    controlador = kp*error(n) + ki*I(n) + kd*D(n);
    
    %limitamos power por temas de error
    Power = int8(controlador);
    if Power >100
        Power = 100;
    else
        if Power < -100    
            Power = -100;
        end
    end
    motor_cabeza.Speed = Power;
   
    n = n + 1;
    
    disp 'PULSAR PARA SALIR..'
   
end

stop(motor_cabeza);
plot(tiempo, ref, 'g')
hold on
plot(tiempo, giro_Cabeza, 'b')
plot(tiempo, error, 'r')

