class Solution {

    public void reverse_array_function(int starting_index , int ending_index , int[] array){
        
        while(starting_index < ending_index){

            int temp = array[starting_index];

            array[starting_index] = array[ending_index];

            array[ending_index] = temp;
            
            starting_index++;
            
            ending_index--;
        }
    }

    public void rotate_array_clockwise(int K_rotations , int N , int array[]){
        
        // To rotate array in "Clockwise" Direction
        
        K_rotations %= N;
        
        reverse_array_function(0 , (N - 1) , array);
        
        reverse_array_function(0 , (K_rotations - 1) , array);
        
        reverse_array_function(K_rotations , (N - 1) , array);
    }

    public void rotate_array_counter_clockwise(int K_rotations , int N , int array[]){
        
        // To rotate array in "Counter - Clockwise" or "Anti - Clockwise" Direction
        
        K_rotations %= N;
        
        reverse_array_function(0 , (N - 1) , array);
        
        reverse_array_function(0 , (N - K_rotations - 1) , array);
        
        reverse_array_function((N - K_rotations) , (N - 1) , array);
    }

    public int[][] rotateGrid(int[][] matrix , int K){

        int R = matrix.length;

        int C = matrix[0].length;

        int total_layers = Math.min(((R / 2) + (R % 2)) , ((C / 2) + (C % 2)));
        
        for(int layer = 0 ; (layer < total_layers) ; layer++){
            
            int starting_i = layer;
            
            int ending_i = (R - layer - 1);
            
            int starting_j = layer;
            
            int ending_j = (C - layer - 1);

            int N = ((((ending_i - starting_i + 1) * 2) + ((ending_j - starting_j + 1) * 2)) - 4);

            int[] layer_elements_array = new int[N];

            int index_1 = 0;
            
            for(int j = starting_j ; (j <= ending_j) ; j++){
                layer_elements_array[index_1++] = matrix[starting_i][j];
            }
            
            for(int i = (starting_i + 1) ; (i <= ending_i) ; i++){
               layer_elements_array[index_1++] = matrix[i][ending_j];
            }
            
            for(int j = (ending_j - 1) ; (j >= starting_j) ; j--){
                layer_elements_array[index_1++] = matrix[ending_i][j];
            }
            
            for(int i = (ending_i - 1) ; (i > starting_i) ; i--){
                layer_elements_array[index_1++] = matrix[i][starting_j];
            }
            
            rotate_array_counter_clockwise(K , N , layer_elements_array);

            int index_2 = 0;

            for(int j = starting_j ; (j <= ending_j) ; j++){
                matrix[starting_i][j] = layer_elements_array[index_2++];
            }
            
            for(int i = (starting_i + 1) ; (i <= ending_i) ; i++){
               matrix[i][ending_j] = layer_elements_array[index_2++];
            }
            
            for(int j = (ending_j - 1) ; (j >= starting_j) ; j--){
                matrix[ending_i][j] = layer_elements_array[index_2++];
            }
            
            for(int i = (ending_i - 1) ; (i > starting_i) ; i--){
                matrix[i][starting_j] = layer_elements_array[index_2++];
            }
        }
        
        return matrix;
    }
}