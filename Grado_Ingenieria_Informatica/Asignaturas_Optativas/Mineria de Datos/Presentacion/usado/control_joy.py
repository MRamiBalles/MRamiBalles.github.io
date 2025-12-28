


#--------------------------------------------------------
#Funcion callback que publica cada vez que recibe un dato
#--------------------------------------------------------
def callback(data):
    


    rospy.loginfo("\r\n\r\n"+"lectura del eje cero %s lectura del eje 1 %s", data.axes[0], data.axes[1])
    

    velocidad= Twist();
    mover = data.buttons[0] 
    velocidad.linear.x=data.axes[1]
    velocidad.linear.y=2.0;
    velocidad.linear.z=0.0;
    velocidad.linear.y=2.0;
    velocidad.angular.x=2.0;
    velocidad.angular.y=2.0;
    velocidad.angular.z=data.axes[0];
    vel_pub.publish(velocidad);

def bucle():
    try:
	rospy.spin();
    except rospy.ROSInterruptException:
        pass


if __name__ == '__main__':


	#Inicia y da nombre al nodo.
	rospy.init_node('control_joystick', anonymous=True)

	#define  los topics de subscripcion y de publicacion
	joy_sub = rospy.Subscriber('/joy',Joy, callback)
	vel_pub = rospy.Publisher('/mobile_base/commands/velocity', Twist,queue_size=1)   
        #inicia el bucle
	bucle()	
       
    