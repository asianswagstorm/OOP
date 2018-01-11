#include <iostream>
#include <cstdlib>
#include <ctime>
#include <fstream>
using namespace std;

const int ROWS=5;
const int COLUMNS = 5;
void initializeBoard(char Board[][COLUMNS]);
void displayBoard(char Board[][COLUMNS]);
void isInputValid(char Board[][COLUMNS]);
void isBoxFree(char Board[][COLUMNS], int &firstCord, int &SecCord);
void isBoxFree2(char Board[][COLUMNS], int &randnum1, int &randnum2, int& firstCord, int& SecCord);
void isGameOver(char Board[][COLUMNS]);

void initializeBoard(char Board[][COLUMNS])
{

	Board[ROWS][COLUMNS];


	for (int i = 0; i < 5; i++)
	{
		
			
			for(int j = 0; j < 5; j++)
		{
			
			Board[i][j] = '-';
			
		}
		
		
	}
}

	

void displayBoard(char Board[][COLUMNS])
{

	ofstream out_stream;

	out_stream.open("result.txt");
	
	cout << "   0 1 2 3 4" << endl;
	cout << "  -----------" << endl;

	out_stream << "Here are the results" << endl;
	out_stream << "   0 1 2 3 4" << endl;
	out_stream << "  -----------" << endl;
	for (int i = 0; i < ROWS; i++)
	{
		cout << i << " ";
		out_stream << i << " ";

		for (int j = 0; j < COLUMNS; j++)
		{
			cout << "|" << Board[i][j];
			out_stream << "|" << Board[i][j];
		}

		cout << "|" << endl;
		cout << "  -----------" << endl;
		out_stream << "|" << endl;
		out_stream << "  -----------" << endl;
	}
	out_stream.close();
}

void isInputValid(char Board[][COLUMNS])
{
	srand(time(0));
	int firstCord, SecCord;

	
	for (int t= 0; t < 25; t++)
	{
	
		int randnum1 = (rand() % 5);
		int randnum2 = (rand() % 5);
		

		if (t == 12)
		{
			cout << " Unfortunately no one wins " << endl;
			
			system("pause");
			exit(1);
		}

		cout << " Human Pick first position (Row number)" << endl;
			cin >> firstCord;
			while (firstCord > 4)
			{
				cout << " Invalid location pick again " << endl;
				cin >> firstCord;
			}
			cout << " Human Pick second position (Column number)" << endl;
			cin >> SecCord;
			while (SecCord > 4)
			{
				cout << " Invalid location pick again " << endl;
				cin >> SecCord;
			}

			isBoxFree(Board, firstCord, SecCord);
			//
			Board[firstCord][SecCord] = 'H';
			displayBoard(Board);
			isGameOver(Board);
			//computer turn
			isBoxFree2(Board, randnum1, randnum2, firstCord, SecCord);
			Board[randnum1][randnum2] = 'P';


			displayBoard(Board);
			isGameOver(Board);
		
	
	
	}

}

void isBoxFree(char Board[][COLUMNS], int &firstCord, int &SecCord)
{
	while (Board[firstCord][SecCord] == 'H' || (Board[firstCord][SecCord] == 'P'))
	{
		cout << " This Position is already chosen, pick another position."<<endl;
		cout << " First Position: ";
		cin >> firstCord;
		cout << " Second Position: ";
		cin >> SecCord;
	}

}

void isBoxFree2(char Board[][COLUMNS], int &randnum1, int &randnum2, int& firstCord, int& SecCord)
{
	while ((Board[randnum1][randnum2] == 'H') || (Board[randnum1][randnum2] == 'P'))
	{
		
		randnum1 = rand() % 5;
		randnum2 = rand() % 5;
			
	}

}


void isGameOver(char Board[][COLUMNS])
{
	if ((Board[0][0] == 'H' && Board[1][1] == 'H' && Board[2][2] == 'H' && Board[3][3] == 'H' && Board[4][4] == 'H')
		|| (Board[0][4] == 'H' && Board[1][3] == 'H' && Board[2][2] == 'H' && Board[3][1] == 'H' && Board[4][0] == 'H')
		|| (Board[0][0] == 'H' && Board[0][1] == 'H' && Board[0][2] == 'H' && Board[0][3] == 'H' && Board[1][0] == 'H'
		&& Board[1][1] == 'H' && Board[1][2] == 'H' && Board[1][3] == 'H')) // first 8 boxes
	{
		cout << "Congratulations! You have defeated the computer." << endl;
		system("pause");
		
		exit(1);
	}

	
	if ((Board[0][0] == 'P' && Board[1][1] == 'P' && Board[2][2] == 'P' && Board[3][3] == 'P' && Board[4][4] == 'P')
		|| (Board[0][4] == 'P' && Board[1][3] == 'P' && Board[2][2] == 'P' && Board[3][1] == 'P' && Board[4][0] == 'P')
		|| (Board[0][0] == 'P' && Board[0][1] == 'P' && Board[0][2] == 'P' && Board[0][3] == 'P' && Board[1][0] == 'P'
		&& Board[1][1] == 'P' && Board[1][2] == 'P' && Board[1][3] == 'P')) // first 8 boxes
	
	{
		cout << "Too Bad! The computer has defeated you." << endl;
		system("pause");
		exit(1);
	}

	
}



int main()
	
	{

		char Board[ROWS][COLUMNS];
		initializeBoard(Board);
		
		cout << " This game is called" "Funny BOXES"" This game is played with a computer." << endl
			<< " You are player H and the computer is player P. " << endl
			<< " To play this game enter the coordinate position you would like to enter. " << endl<<endl<<endl;
	
		displayBoard(Board);

		isInputValid(Board);
		
		
		
		system ("pause");
			return 0;
		}



