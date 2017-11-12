[num] = textread('wordFreqBigwithModeonly_Skipgram');
num = log(num+1);
[r,p] = corrcoef(num);
scatter(num(:,1),num(:,2),'r.')
xlabel('log(词频)')
ylabel('log(词向量的模长)')
title('大数据集下log(词频)与log(词向量模长)的关系')
box on
saveas(gcf,'M-vectorBig.png')