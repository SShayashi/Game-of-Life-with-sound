package com.sshayashi.musicgame;

/**
 * Created by starprince on 2017/06/24.
 */

public class CellularAutomata {
    int[][][] world;
    int width, height;



    CellularAutomata(int width, int height){
        this.width = width;
        this.height = height;
        //ここで、1つめは現在の世代、2つめは次の世代を保管するために使う
        world = new int[this.width][this.height][2];
    }

    void update(){

        for (int x = 0; x < width; x=x+1) {
            for (int y = 0; y < height; y=y+1) {

                if ((world[x][y][1] == 1) || (world[x][y][1] == 0 && world[x][y][0] == 1))
                {
                    world[x][y][0] = 1;
//                    point(x, y);
                }
                if (world[x][y][1] == -1)
                {
                    world[x][y][0] = 0;
                }
                world[x][y][1] = 0;
            }
        }
    }

    /* 周囲のセルの生死を判定する関数 */
    int neighbors(int x, int y)
    {
        return world[(x + 1) % width][y][0] +
                world[x][(y + 1) % height][0] +
                world[(x + width - 1) % width][y][0] +
                world[x][(y + height - 1) % height][0] +
                world[(x + 1) % width][(y + 1) % height][0] +
                world[(x + width - 1) % width][(y + 1) % height][0] +
                world[(x + width - 1) % width][(y + height - 1) % height][0] +
                world[(x + 1) % width][(y + height - 1) % height][0];
    }
}
