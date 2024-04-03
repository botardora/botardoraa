// Botar Dora 
// On a chessboard of size 𝑛 × 𝑛, there is a knight at position (𝑥0, 𝑦0) and a bishop at position (𝑥, 𝑦).
// The knight needs to move from this position to position (𝑥1, 𝑦1) without stepping on any square more 
// than once and without stopping at a square where the bishop could capture it. 
// Output the number of ways this can be achieved.


#include <iostream>

using namespace std;
struct position
{
    int x, y;
};

bool isok(position bishop, int n, int x, int y, int h[10][10]);
void step(position bishop, position goal, int n, int x, int y, int k, int &s, int h[10][10], position way[]);

int main()
{
    int n, s = 0, h[10][10] = {}, k = 1;
    position bishop, knight, goal, way[50];
    cout << "Board size: ";
    cin >> n;
    cout << "Enter bishop's position (x y): ";
    cin >> bishop.x >> bishop.y;
    cout << "Enter knight's position (x y): ";
    cin >> knight.x >> knight.y;
    cout << "Enter goal position (x y): ";
    cin >> goal.x >> goal.y;
    int x, y;
    x = knight.x;
    y = knight.y;
    step(bishop, goal, n, x, y, k, s, h, way);
    cout << s;
    return 0;
}


void step(position bishop, position goal, int n, int x, int y, int k, int& s, int h[10][10], position way[])
{
    if (x == goal.x && y == goal.y)
        s = s + 1;
    else
    {
        if (isok(bishop, n, x, y, h))
        {
            h[x][y] = 1;
            way[k].x = x;
            way[k].y = y;
            step(bishop, goal, n, x + 1, y + 2, k + 1, s, h, way);
            step(bishop, goal, n, x - 1, y + 2, k + 1, s, h, way);
            step(bishop, goal, n, x + 1, y - 2, k + 1, s, h, way);
            step(bishop, goal, n, x - 1, y - 2, k + 1, s, h, way);
            step(bishop, goal, n, x + 2, y + 1, k + 1, s, h, way);
            step(bishop, goal, n, x + 2, y - 1, k + 1, s, h, way);
            step(bishop, goal, n, x - 2, y + 1, k + 1, s, h, way);
            step(bishop, goal, n, x - 2, y - 1, k + 1, s, h, way);
            h[x][y] = 0;
        }
    }
}

bool isok(position bishop, int n, int x, int y, int h[10][10])
{
    if (x<1 || y<1 || x>n || y>n)
        return false;
    if (x - y == bishop.x - bishop.y || x + y == bishop.x + bishop.y)
        return false;
    if (h[x][y])
        return false;
    return true;
}