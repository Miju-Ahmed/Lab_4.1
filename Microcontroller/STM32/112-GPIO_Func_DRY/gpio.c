#include "stm32f4xx.h"
#include "gpio.h"

void GPIOPortInit(char GPIO_port){
	RCC->AHB1ENR |= (1<<GPIO_port);
}


GPIO_TypeDef * get_GPIO(char GPIO_port){
	GPIO_TypeDef * target_port;
	
	switch(GPIO_port)
	{
		case PortA: target_port = GPIOA;break;
		case PortB: target_port = GPIOB;break;
		case PortC : target_port = GPIOC;break;
		#ifdef GPIOD
		case PortD : target_port = GPIOD;break;
		#endif
		#ifdef GPIOE
		case PortE : target_port = GPIOE;break;
		#endif
		#ifdef GPIOF
		case PortF : target_port = GPIOF;break;
		#endif
		#ifdef GPIOG
		case PortG : target_port = GPIOG;break;
		#endif
		#ifdef GPIOH
		case PortH : target_port = GPIOH;break;
		#endif
		#ifdef GPIOI
		case PortI : target_port = GPIOI;break;
		#endif
		#ifdef GPIOJ
		case PortJ : target_port = GPIOJ;break;
		#endif
		#ifdef GPIOK
		case PortK : target_port = GPIOK;break;
		#endif
	
	}
	
	return target_port;
}

void PinModeSet(int PortPin, char mode){
	char port = PortPin / 16;
	char pin = PortPin % 16;
	GPIO_TypeDef * GPIO = get_GPIO(port);

	GPIO->MODER &= ~(0x3<<(pin*2)); // Resetting the value of the bits
	GPIO->MODER |= (mode<<pin*2); // Setting up bit value to the mode
}

void PinModeOut(int PortPin){
	PinModeSet(PortPin, OUT);
}
void PinModeIn(int PortPin){
	PinModeSet(PortPin, IN);
}


void PinOutputSet(int PortPin){
	char port = PortPin / 16;
	char pin = PortPin % 16;
	GPIO_TypeDef * GPIO = get_GPIO(port);
	GPIOPortInit(port);
	PinModeOut(PortPin);
	GPIO->MODER &= ~(0x3<<pin*2); // Resetting the values
	GPIO->MODER |= (OUT<<pin*2); // Setting up Pin output
	
	GPIO->OTYPER &= ~(0b1<<pin); // Set up the pin as pp
	
	GPIO->OSPEEDR &= ~(0x3<<(pin*2)); // Resetting the value of the bits
	GPIO->OSPEEDR |= (HS<<pin*2); // Setting up bit value to the mode

}

void PinInputSet(int PortPin){
	char port = PortPin / 16;
	char pin = PortPin % 16;
	GPIO_TypeDef * GPIO = get_GPIO(port);
	GPIOPortInit(port);
	PinModeIn(PortPin);
	GPIO->OTYPER &= ~(0b1<<pin); // Set up the pin as pp
	
	GPIO->PUPDR &= ~(0x3<<(pin*2)); // Resetting the values
	GPIO->PUPDR |= (PD<<pin*2); // Setting up Pin  as PD
}

void PinW(int PortPin, char state){
	char port = PortPin / 16;
	char pin = PortPin % 16;
	GPIO_TypeDef * GPIO = get_GPIO(port);
	
	if(state)
	{
		GPIO->ODR |= 1<<pin; // Should set Pin to HIGH or on
	}
	else 
	{
		GPIO->ODR &= ~(1<<pin); // Should reset pin to Low or OFF
	}
	
}

char PinR(int PortPin){
	char port = PortPin / 16;
	char pin = PortPin % 16;
	GPIO_TypeDef * GPIO = get_GPIO(port);
	if(GPIO->IDR & (1<<pin))
	{
		return 0xff; // if return 1 I try to ~1 is  0xFE / by ~0xff is 0
	}
	else
	{
		return 0;
	}
	
}

void PinToggle(int PortPin){
	char port = PortPin / 16;
	char pin = PortPin % 16;
	GPIO_TypeDef * GPIO = get_GPIO(port);
	
	PinR(PortPin) ? PinW(PortPin,OFF) : PinW(PortPin,ON);

}


void PinsSet(int * PinsList, char pinNumber, char state){
	int i;
	
	for(i=0;i<pinNumber;i++)
	{
		if(state == IN)
		{
			PinInputSet(PinsList[i]);
		} 
		else if(state == OUT)
		{
			PinOutputSet(PinsList[i]);
		}
	
	}
}
void PinsInputSet(int * PinsList, char pinNumber){
	PinsSet(PinsList, pinNumber, IN);
}

void PinsOutputSet(int * PinsList, char pinNumber){
	PinsSet(PinsList, pinNumber, OUT);
}


