clc
clear all

mi_Robot=legoev3('USB');

mapa = [];
%% Definicion motor de la cabeza
motor_cabeza = motor(mi_Robot,'A');
start(motor_cabeza);

%% Necesario un reset
resetRotation(motor_cabeza)

Sonar = sonicSensor(mi_Robot,4)
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
Amplitud = 100;% 100 para evitar el latigazo del cable y compensar que no llegue a todos los angulos
Delay = 0.8;
Periodo = 10;
ref(1) = signal_vf_v2(tiempo(n), Periodo, Delay, Amplitud);
error(1) = ref(1) - giro_Cabeza(1);
I(n) = 0;
D(n) = 0;
kp = 0.6;
ki = 1.5;
kd = 0.07; 
while(readTouch(Pulsador) == 0)
    n = n+1;
    % lectura del tiempo
    tiempo(n) = toc(tstart);
    giro_Cabeza(n)=double(readRotation(motor_cabeza));
    ref(n) = signal_vf_v2(tiempo(n), Periodo, Delay, Amplitud);

    % cálculo del error proporcional
    error(n)= ref(n) - giro_Cabeza(n);

    % cálculo del error integral
    dt = tiempo(n) - tiempo(n-1);
    I(n) = I(n-1) + error(n)*dt;

    % cálculo del error derivado
    D(n) = (error(n) - error(n-1))/dt

    %def controlador
    controlador = kp*error(n) + 0*ki*I(n) + 0*kd*D(n);
    
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
    distancia(n) = double( readDistance(Sonar));
    distanciaParametro(n) = distancia(n) * 100;
    %giro_CabezaParametro(n) = giro_Cabeza(n) * pi / 180;
    pinta_robot_v3(0,0,0,giro_Cabeza(n)* pi / 180, distanciaParametro(n),mapa);

    drawnow
    disp 'PULSAR PARA SALIR..'
   
end

stop(motor_cabeza);
figure
plot(tiempo, ref, 'g')
hold on
plot(tiempo, giro_Cabeza, 'b')
plot(tiempo, error, 'r')


